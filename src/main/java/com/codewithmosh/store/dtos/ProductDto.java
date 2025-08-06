package com.codewithmosh.store.dtos;

import com.codewithmosh.store.entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private byte categoryId;
}
