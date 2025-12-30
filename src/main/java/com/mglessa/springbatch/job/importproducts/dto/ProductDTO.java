package com.mglessa.springbatch.job.importproducts.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;
}
