package org.example.ex_meubles.service;

import org.example.ex_meubles.entity.Furniture;
import org.example.ex_meubles.repository.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {
    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    public Furniture getFurnitureById(Long id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    public Furniture saveFurniture(Furniture furniture) { return furnitureRepository.save(furniture); }

    public void delete(Furniture furniture){
        furnitureRepository.delete(furniture);
    }
}
