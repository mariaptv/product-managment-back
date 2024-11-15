package com.example.demo.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProductService;
import com.example.demo.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * REST controller for managing product operations.
 * Handles CRUD operations for the `Product` entity.
 */
@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    private ProductService productService; // Service layer for business logic

    /**
     * Retrieves a list of all products.
     *
     * @return a ResponseEntity containing the list of products
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    /**
     * Retrieves a single product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return a ResponseEntity containing the product
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    /**
     * Saves a new product.
     *
     * @param product the product to be saved
     * @return a ResponseEntity containing the saved product
     */
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        try {
            // Save the product and generate the URI for the new resource
            Product productSave = productService.save(product);
            return ResponseEntity.created(new URI("/products/" + productSave.getId())).body(productSave);
        } catch (Exception e) {
            // Return a BAD_REQUEST status if an exception occurs
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Updates an existing product by its ID.
     *
     * @param id      the ID of the product to update
     * @param product the updated product data
     * @return a ResponseEntity containing the updated product
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return a ResponseEntity containing a boolean indicating success
     */
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") Long id) {
        // Delete the product
        productService.deleteById(id);
        // Check if the product still exists and return the result
        return ResponseEntity.ok(!(productService.findById(id) != null));
    }
}
