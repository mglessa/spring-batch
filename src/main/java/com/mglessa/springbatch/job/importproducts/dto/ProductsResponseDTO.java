package com.mglessa.springbatch.job.importproducts.dto;

import com.mglessa.springbatch.job.importusers.dto.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductsResponseDTO {
    private List<ProductDTO> products;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
