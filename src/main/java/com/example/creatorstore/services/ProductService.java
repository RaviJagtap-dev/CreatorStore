package com.example.creatorstore.services;

import com.example.creatorstore.entities.Product;
import com.example.creatorstore.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Product createProduct(Product  product) {
        Product existingProduct = productRepository.findById(product.getId()).isPresent() ? productRepository.findById(product.getId()).get() : product;
        return productRepository.save(product);
    }

    public Product updateProduct(Long id,Product  product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"+id));

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());

        return productRepository.save(existingProduct);
    }
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductByID(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"+id));
    }

    public void deleteProductByID(Long id ) {
        productRepository.deleteById(id);
    }
}
