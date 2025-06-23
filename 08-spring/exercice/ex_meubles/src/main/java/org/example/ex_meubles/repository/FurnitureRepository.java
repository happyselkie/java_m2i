package org.example.ex_meubles.repository;

import org.example.ex_meubles.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture,Long> {
}
