package org.example.product_session.controller;

import jakarta.servlet.http.HttpSession;
import org.example.product_session.service.CartService;
import org.example.product_session.util.CartItems;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cart")
public class CartSessionController {

    private final CartService cartService;
    private HttpSession session;

    public CartSessionController(CartService cartService, HttpSession session) {
        this.cartService = cartService;
        this.session = session;
    }

    @GetMapping()
    public ResponseEntity<List<CartItems>> seeCart() {
        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");

        if (!cartItems.isEmpty()) {
            return ResponseEntity.ok(cartService.getCartItems());
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/valid")
    public ResponseEntity<List<String>> validCart() {
        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");

        if (!cartItems.isEmpty()) {
            return ResponseEntity.ok(cartService.validCart());
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody CartItems cartItem) {

        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }
        cartService.setCartItems(cartItems);

        if (cartItem.getQuantity() < 1) cartItem.setQuantity(1);

        if (cartItems.isEmpty()) {
           cartService.addItem(cartItem);
        } else {
            for (CartItems item : cartItems) {
                if (item.getProductId().equals(cartItem.getProductId())) {
                    cartService.updateItem(cartItem.getProductId(), cartItem.getQuantity());
                }
            }
        }

        session.setAttribute("cart", cartService.getCartItems());

        return ResponseEntity.ok(cartService.getProduct(cartItem.getProductId()).getName() + " a été ajouté au panier.");
    }


    @GetMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id) {
        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");
        cartService.setCartItems(cartItems);

        if (cartItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Le panier est vide");
        } else {
            if (!cartService.deleteItem(id)) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé dans le panier");
            session.setAttribute("cart", cartService.getCartItems());
        }

        return ResponseEntity.ok(cartService.getProduct(id).getName() + " a été retiré du panier.");
    }

}
