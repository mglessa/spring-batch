package com.mglessa.springbatch.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "products", schema = "dummy")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;

}
