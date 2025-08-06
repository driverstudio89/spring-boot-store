package com.codewithmosh.store.carts;

import com.codewithmosh.store.products.ProductNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/carts")
@Tag(name = "Carts")
public class CardController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCard(
            UriComponentsBuilder uriBuilder
    ) {
        CartDto cartDto = cartService.createCart();

        uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    @Operation(summary = "Add product to cart")
    public ResponseEntity<CartItemDto> addToCart(
            @Parameter(description = "The ID of the cart")
            @PathVariable UUID cartId,

            @RequestBody AddItemToCartRequest request) {

        CartItemDto cartItemDto = cartService.addToCart(cartId, request.getProductId());

        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable UUID cartId) {

        CartDto cartDto = cartService.getCart(cartId);

        return ResponseEntity.ok(cartDto);
    }

    @PutMapping("/{cartId}/items/{productId}")
    public ResponseEntity<?> updateItem(
            @PathVariable("cartId") UUID cartId,
            @PathVariable("productId") Long productId,
            @RequestBody @Valid UpdateCartItemRequest request
    ) {
        CartItemDto cartItemDto = cartService.updateCartItem(cartId, productId, request.getQuantity());

        return ResponseEntity.ok(cartItemDto);
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public ResponseEntity<?> removeItem(
            @PathVariable("cartId") UUID cartId,
            @PathVariable("productId") Long productId) {

        cartService.removeCartItem(cartId, productId);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cartId}/items")
    public ResponseEntity<Void> clearCart(@PathVariable("cartId")  UUID cartId) {

        cartService.clearCart(cartId);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCartNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error", "Cart not found."));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "Product not found in the cart."));
    }

}
