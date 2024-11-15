
# Product Management Backend

This is the backend repository for the Product Management System. The application provides RESTful APIs for managing products, including operations to create, retrieve, update, and delete products.

## Features

- **Product Management**:
  - Create new products.
  - Retrieve all products or a single product by ID.
  - Update existing products.
  - Delete products by ID.

- **Validation**:
  - Ensures required fields (e.g., name, price, category, etc.) are not null.
  - Enforces unique constraints on SKU.

- **RESTful API**:
  - Exposes endpoints for seamless integration with frontend applications.

## Technology Stack

- **Backend Framework**: Spring Boot
- **Database**: JPA/Hibernate with a relational database
- **HTTP Framework**: Spring Web
- **Validation**: JSR-303 Bean Validation (via Hibernate Validator)

## Prerequisites

- JDK 17 
- Maven or Gradle build tool
- Relational database PostgreSQL
## Components

### ProductController
- Handles HTTP requests for product-related operations.
- **Endpoints**:
  - **`GET /products/`**: Fetch all products.
  - **`GET /products/{id}`**: Fetch a product by ID.
  - **`POST /products/`**: Create a new product.
  - **`PUT /products/{id}`**: Update an existing product.
  - **`DELETE /products/delete/{id}`**: Delete a product by ID.

### ProductService
- Provides business logic for product operations.
- Interacts with the database via the `ProductRepository`.

### Product
- Represents the `Product` entity mapped to the `products` table in the database.
- **Fields**:
  - `id`: Primary key (auto-generated).
  - `name`: Name of the product (required).
  - `price`: Price of the product (required).
  - `category`: Category of the product (required).
  - `sku`: Unique stock keeping unit (required, unique).
  - `description`: Description of the product (required, max length 500).
  - `stock`: Stock quantity (required).
  - `addedDate`: Date the product was added.

### ProductRepository
- Interface for database interactions using Spring Data JPA.

## Validation
- Enforces non-null constraints on key fields.
- Enforces uniqueness of SKU.
