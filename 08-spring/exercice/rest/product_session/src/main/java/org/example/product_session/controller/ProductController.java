package org.example.product_session.controller;

import jakarta.validation.Valid;
import org.example.product_session.dto.ProductReceiveDto;
import org.example.product_session.dto.ProductResponseDto;
import org.example.product_session.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() { return ResponseEntity.ok(productService.get()); }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(productService.get(id)); }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@Valid @RequestBody ProductReceiveDto product) { return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product)); }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long id, @RequestBody ProductReceiveDto product) { return ResponseEntity.ok(productService.update(id, product));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok(String.format("Deleted product with ID %s", id));
    }


}
