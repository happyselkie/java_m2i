package org.example.product.service;

import org.example.product.dto.ProductReceiveDto;
import org.example.product.dto.ProductResponseDto;
import org.example.product.exception.NotFoundException;
import org.example.product.model.Product;
import org.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto create(ProductReceiveDto productReceiveDto){
        return productRepository.save(productReceiveDto.dtoToEntity()).entityToDto();
    }

    public ProductResponseDto get(Integer id){ return productRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<ProductResponseDto> get(){
        return productRepository.findAll().stream().map(Product::entityToDto).toList();
    }

    public ProductResponseDto update(Integer id, ProductReceiveDto ProductReceiveDto){
        Product productToUpdate = productRepository.findById(id).orElseThrow(NotFoundException::new);
        Product productGet = ProductReceiveDto.dtoToEntity();
        productToUpdate.setName(productGet.getName());
        productToUpdate.setPrice(productGet.getPrice());
        return productRepository.save(productToUpdate).entityToDto();
    }

    public void delete(Integer id){ productRepository.deleteById(id); }
}
