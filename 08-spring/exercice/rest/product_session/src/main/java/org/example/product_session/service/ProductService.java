package org.example.product_session.service;

import org.example.product_session.dto.ProductReceiveDto;
import org.example.product_session.dto.ProductResponseDto;
import org.example.product_session.entity.Product;
import org.example.product_session.exception.NotFoundException;
import org.example.product_session.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto create(ProductReceiveDto productReceiveDto){ return productRepository.save(productReceiveDto.dtoToEntity()).entityToDto(); }

    public ProductResponseDto get(Long id){ return productRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<ProductResponseDto> get(){
        return productRepository.findAll().stream().map(Product::entityToDto).toList();
    }

    public ProductResponseDto update(Long id, ProductReceiveDto ProductReceiveDto){
        Product productToUpdate = productRepository.findById(id).orElseThrow(NotFoundException::new);
        Product productGet = ProductReceiveDto.dtoToEntity();
        productToUpdate.setName(productGet.getName());
        productToUpdate.setPrice(productGet.getPrice());
        return productRepository.save(productToUpdate).entityToDto();
    }

    public void delete(Long id){ productRepository.deleteById(id); }

}
