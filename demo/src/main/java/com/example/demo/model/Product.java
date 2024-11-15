package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity class representing a Product.
 * Maps to the "products" table in the database.
 */
@Entity
@Table(name = "products")
public class Product {

    // Primary key for the Product entity, with auto-generated value
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Name of the product (cannot be null)
    @Column(nullable = false)
    private String name;

    // Price of the product (cannot be null)
    @Column(nullable = false)
    private Double price;

    // Category of the product (cannot be null)
    @Column(nullable = false)
    private String category;

    // SKU (Stock Keeping Unit) must be unique and cannot be null
    @Column(unique = true, nullable = false)
    private String sku;

    // Description of the product, limited to 500 characters and cannot be null
    @Column(length = 500, nullable = false)
    private String description;

    // Stock quantity of the product (cannot be null)
    @Column(nullable = false)
    private Integer stock;

    // Date when the product was added
    private LocalDate addedDate;

    /**
     * Default constructor.
     * Required by JPA for entity instantiation.
     */
    public Product() {}

    /**
     * Parameterized constructor for creating a new Product instance.
     *
     * @param name        the name of the product
     * @param price       the price of the product
     * @param category    the category of the product
     * @param sku         the unique SKU of the product
     * @param description a brief description of the product
     * @param stock       the stock quantity of the product
     * @param addedDate   the date the product was added
     */
    public Product(String name, Double price, String category, String sku, String description, Integer stock,
                   LocalDate addedDate) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.sku = sku;
        this.description = description;
        this.stock = stock;
        this.addedDate = addedDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
}
