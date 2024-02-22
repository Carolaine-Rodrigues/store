package br.com.produts.store.domain.entity;

import br.com.produts.store.domain.dto.ProductsRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="tb_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private BigDecimal price;
    private String description;


    public Product(ProductsRequestDTO data){
        this.name = data.name();
        this.image = data.image();
        this.price = data.price();
        this.description = data.description();
    }
}
