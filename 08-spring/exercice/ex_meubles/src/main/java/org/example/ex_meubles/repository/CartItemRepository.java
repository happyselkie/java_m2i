package org.example.ex_meubles.repository;

import org.example.ex_meubles.entity.CartItem;
import org.example.ex_meubles.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
