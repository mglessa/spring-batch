package com.mglessa.springbatch.job.importproducts.writer;

import com.mglessa.springbatch.domain.product.Product;
import com.mglessa.springbatch.domain.product.ProductRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class ProductWriter implements ItemWriter<Product> {
    private final ProductRepository repository;

    public ProductWriter(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @Override
    public void write(Chunk<? extends Product> chunk) {
        repository.saveAll(chunk);
    }
}
