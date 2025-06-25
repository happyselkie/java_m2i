package org.example.product_session.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.product_session.util.CartItems;
import org.example.product_session.dto.ProductReceiveDto;
import org.example.product_session.dto.ProductResponseDto;
import org.example.product_session.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cart")
public class CartSessionController {

    private final ProductService productService;
    private HttpSession session;

    public CartSessionController(ProductService productService, HttpSession session) {
        this.productService = productService;
        this.session = session;
    }

    @GetMapping()
    public ResponseEntity<List<CartItems>> seeCart() {
        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/valid")
    public ResponseEntity<List<String>> validCart() {
        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");
        List<String> cartItemsList = new ArrayList<>();
        Double sum = 0.0;

        if (cartItems != null) {
            for (CartItems items : cartItems) {
                sum += items.getQuantity()*items.getProduct().getPrice();
                String line = items.getProduct().getName() + " : " + items.getQuantity() + " x " + items.getProduct().getPrice() + " = " + items.getQuantity()*items.getProduct().getPrice();
                cartItemsList.add(line);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }

        if (cartItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        String total = "Total du panier : " + sum;
        cartItemsList.add(total);


        return ResponseEntity.ok(cartItemsList);
    }

    @GetMapping("/add/{id}")
    public ResponseEntity<String> add(@PathVariable Long id, @RequestParam(value = "quantity", required = false) Integer quantity) {

        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");
        CartItems cartItem = null;

        if (quantity == null || quantity < 1) quantity = 1;

        if (cartItems == null || cartItems.isEmpty()) {
            cartItems = new ArrayList<>();
        } else {
            for (CartItems item : cartItems) {
                if (item.getProduct().getId().equals(id)) {
                    cartItem = item;
                }
            }
        }

        if (cartItem == null) {
            cartItem = new CartItems(productService.get(id), quantity);
            cartItems.add(cartItem);
        } else{
            cartItem.setQuantity(quantity);
        }

        session.setAttribute("cart", cartItems);

        return ResponseEntity.ok(cartItem.getProduct().getName() + " a été ajouté au panier.");
    }


    @GetMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id) {

        List<CartItems> cartItems = (List<CartItems>) session.getAttribute("cart");
        CartItems cartItem = null;

        if (cartItems == null || cartItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Le panier est vide");
        } else {
            for (CartItems item : cartItems) {
                if (item.getProduct().getId().equals(id)) {
                    cartItems.remove(item);
                }
            }
        }

        if (cartItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé dans le panier");
        }

        session.setAttribute("cart", cartItems);

        return ResponseEntity.ok(cartItem.getProduct().getName() + " a été retiré du panier.");
    }

}
