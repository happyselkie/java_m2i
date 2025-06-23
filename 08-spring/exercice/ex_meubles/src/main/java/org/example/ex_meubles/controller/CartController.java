package org.example.ex_meubles.controller;

import jakarta.validation.Valid;
import org.example.ex_meubles.entity.CartItem;
import org.example.ex_meubles.entity.Furniture;
import org.example.ex_meubles.service.CartService;
import org.example.ex_meubles.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final FurnitureService furnitureService;


    public CartController(CartService cartService, FurnitureService furnitureService) {
        this.cartService = cartService;
        this.furnitureService = furnitureService;
    }

    @GetMapping("/list")
    public String CartPage(Model model){
        List<CartItem> cartItems = cartService.getAllCartItems();
        model.addAttribute("cartItems",cartItems);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("furnitureId")Long furnitureId, @ModelAttribute("cartItem") CartItem cartItem, Model model){
        int quantity = cartItem.getQuantity();
        Furniture furniture = furnitureService.getFurnitureById(cartItem.getFurniture().getFurnitureId());
        int stock = furniture.getStock();

        if(quantity > stock) {
            model.addAttribute("errMessage", "Quantity exceeds stock");
            return "redirect:/furnitures/list";
        }

        furniture.setStock(furniture.getStock() - quantity);
        furnitureService.saveFurniture(furniture);

        cartItem.setFurniture(furniture);
        cartService.addToCart(cartItem);
        return "cart";
    }

    @GetMapping("/delete")
    public String deleteToCart(@RequestParam("id")Long id){
        CartItem cartItem = cartService.getById(id);
        Furniture furniture = cartItem.getFurniture();
        furniture.setStock(furniture.getStock() + cartItem.getQuantity());
        furnitureService.saveFurniture(furniture);

        cartService.removeFromCart(cartItem);
        return "cart";
    }

    @GetMapping("/clear")
    public String clearCart(){
        cartService.clearCart();
        return "cart";
    }
}
