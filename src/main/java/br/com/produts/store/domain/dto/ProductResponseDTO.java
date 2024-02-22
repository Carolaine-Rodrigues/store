package br.com.produts.store.domain.dto;

import br.com.produts.store.domain.entity.Product;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id, String name, String image, BigDecimal price, String description) {

    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getImage(), product.getPrice(), product.getDescription());
    }
}
