package org.example.product.controller;

import org.example.product.dto.ProductReceiveDto;
import org.example.product.dto.ProductResponseDto;
import org.example.product.model.Product;
import org.example.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() { return ResponseEntity.ok(productService.get()); }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductReceiveDto product) { return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product)); }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Integer id) { return ResponseEntity.ok(productService.get(id)); }
}


