package org.example.ex_meubles.service;

import org.example.ex_meubles.entity.CartItem;
import org.example.ex_meubles.entity.Furniture;
import org.example.ex_meubles.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartItemRepository cartItemRepository;

    public CartService(CartItemRepository cartItemRepository) {this.cartItemRepository = cartItemRepository;}

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public CartItem addToCart(CartItem cartItem) { return cartItemRepository.save(cartItem); }

    public void removeFromCart(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }

    public void clearCart(){
        cartItemRepository.deleteAll();
    }
}
