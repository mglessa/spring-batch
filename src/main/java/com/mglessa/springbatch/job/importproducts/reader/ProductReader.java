package com.mglessa.springbatch.job.importproducts.reader;

import com.mglessa.springbatch.domain.product.Product;
import com.mglessa.springbatch.job.importproducts.dto.ProductDTO;
import com.mglessa.springbatch.job.importproducts.dto.ProductsResponseDTO;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Iterator;


@Component
public class ProductReader implements ItemReader<Product> {

    private final RestClient restClient;
    private Iterator<Product> iterator;

    public ProductReader(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://dummyjson.com/")
                .build();
    }

    @Override
    public Product read()  {
        if(iterator == null) {
            ProductsResponseDTO response = restClient.get()
                    .uri("/products")
                    .retrieve()
                    .body(ProductsResponseDTO.class);

            if (response == null || response.getProducts() == null) {
                return null;
            }

            iterator = response.getProducts().stream()
                    .map(this::toEntity)
                    .iterator();
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
