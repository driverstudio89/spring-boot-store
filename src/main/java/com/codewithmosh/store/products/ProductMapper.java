package com.codewithmosh.store.products;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);

    Product toEntity(ProductDto ProductDto);

    @Mapping(target = "id", ignore = true)
    void updateProduct(ProductDto ProductDto,@MappingTarget Product product);
}
