package com.mglessa.springbatch.job.importproducts.reader;

import com.mglessa.springbatch.domain.product.Product;
import com.mglessa.springbatch.job.importproducts.dto.ProductDTO;
import com.mglessa.springbatch.job.importproducts.dto.ProductsResponseDTO;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;

@Component
public class ProductReader implements ItemReader<Product> {

    private final RestTemplate restTemplate = new RestTemplate();
    private Iterator<Product> iterator;

    @Override
    public Product read()  {
        if(iterator == null) {
            ProductsResponseDTO response = restTemplate.getForObject(
                    "https://dummyjson.com/products",
                    ProductsResponseDTO.class
            );

            if (response == null || response.getProducts() == null) {
                return null;
            }

            List<Product> products = response.getProducts().stream()
                    .map(this::toEntity)
                    .toList();

            iterator = products.iterator();
        }

        return iterator.hasNext() ? iterator.next() : null;
    }

    private Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}
