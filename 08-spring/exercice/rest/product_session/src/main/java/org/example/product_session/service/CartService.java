package org.example.product_session.service;

import lombok.Getter;
import org.example.product_session.dto.ProductResponseDto;
import org.example.product_session.util.CartItems;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final ProductService productService;
    private List<CartItems> cartItems;

    public CartService(ProductService productService) {
        this.productService = productService;
        this.cartItems = new ArrayList<>();
    }

    public List<CartItems> getCartItems() {
        return cartItems;
    }

    public List<CartItems> setCartItems(List<CartItems> cartItems) {
        return this.cartItems = cartItems;
    }

    public ProductResponseDto getProduct(Long id) {
        return productService.get(id);
    }

    public CartItems addItem(CartItems cartItem) {
        cartItems.add(cartItem);
       return cartItem;
    }

    public CartItems updateItem(Long productId, Integer quantity) {
        for (CartItems item : cartItems) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(quantity);
                return item;
            }
        }
        return null;
    }

    public boolean deleteItem(Long productId) {
        for (CartItems item : cartItems) {
            if (item.getProductId().equals(productId)) {
                cartItems.remove(item);
                return true;
            }
        }
        return false;
    }

    public List<String> validCart() {
        List<String> cartItemsList = new ArrayList<>();
        Double sum = 0.0;

        for (CartItems items : cartItems) {
            sum += items.getQuantity()*getProduct(items.getProductId()).getPrice();
            String line = getProduct(items.getProductId()).getName() + " : " + items.getQuantity() + " x " + getProduct(items.getProductId()).getPrice() + " = " + items.getQuantity()*getProduct(items.getProductId()).getPrice()+"\n";
            cartItemsList.add(line);
        }
        cartItemsList.add("Total du panier : " + sum);
        return cartItemsList;
    }

    public void clear() {
        cartItems.clear();
    }

}
