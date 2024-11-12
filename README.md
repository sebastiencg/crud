# Product API Documentation

This document serves as a guide for using the Product API endpoints for managing products. The API supports typical CRUD operations for products with authentication.

## Prerequisites

- Ensure your server is running at `http://localhost:8080`.
- The Authorization token used here is a sample and may need to be refreshed periodically.

## Authentication

First, you need to register and authenticate to get an authorization token.

### Register

```http_request
POST http://localhost:8080/api/register
Content-Type: application/json

{
  "username": "seb",
  "password": "1234"
}

```

### Authenticate

```http_request
POST http://localhost:8080/api/authenticate
Content-Type: application/json

{
  "username": "seb",
  "password": "1234"
}

```

## Endpoints

### Get All Products

Retrieve all products.

```http_request
GET http://localhost:8080/api/products
Authorization: Bearer {{authToken}}
Content-Type: application/json

```

### Create a Product

Add a new product to the inventory.

```http_request
POST http://localhost:8080/api/product/create
Authorization: Bearer {{authToken}}
Content-Type: application/json

{
  "name": "test",
  "description": "test20",
  "price": 9.99,
  "quantity": 10
}

```

### Get a Product by ID

Retrieve a product by its ID.

```http_request
GET http://localhost:8080/api/product/2
Authorization: Bearer {{authToken}}
Content-Type: application/json

```

### Update a Product by ID

Update an existing product by its ID.

```http_request
PATCH http://localhost:8080/api/product/2/update
Authorization: Bearer {{authToken}}
Content-Type: application/json

{
  "name": "test update",
  "description": "test20 update",
  "price": 9.99,
  "quantity": 10
}

```

### Delete a Product by ID

Delete a product by its ID.

```http_request
DELETE http://localhost:8080/api/product/3/delete
Authorization: Bearer {{authToken}}

```

## Note

- Replace `{{authToken}}` with the actual Bearer token you get from the authentication process.
- Response files (`<> 2024-11-12T123450.200.json`) will store the API responses for your reference.