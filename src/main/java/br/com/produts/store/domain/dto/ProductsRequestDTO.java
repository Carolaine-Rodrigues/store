package br.com.produts.store.domain.dto;

import java.math.BigDecimal;

public record ProductsRequestDTO(Long id, String name, String image, BigDecimal price, String description) {

}
