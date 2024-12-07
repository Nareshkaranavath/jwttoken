package com.jwttoken.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private record Product(Integer productId, String name, double price) {
    }
    private final List<Product> products = new ArrayList<>(
            List.of(new Product(1, "iPhone", 99999.00),
            new Product(2, "Moto", 99299.00)
            )
    );
    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public Product saveRecord(@RequestBody Product product) {
        products.add(product);
        return product; // Returning the added product.
    }
}
