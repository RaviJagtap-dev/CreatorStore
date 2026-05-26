package com.example.creatorstore.controllers;

import com.example.creatorstore.entities.Product;
import com.example.creatorstore.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product  product) {
        return productService.createProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct( @PathVariable Long id,@Valid @RequestBody  Product  product) {
        return productService.updateProduct(id, product);
    }
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productService.getProductByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductByID(@PathVariable Long id ) {
        productService.deleteProductByID(id);
    }


}
