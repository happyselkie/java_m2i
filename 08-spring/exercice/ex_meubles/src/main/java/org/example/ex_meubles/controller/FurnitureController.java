package org.example.ex_meubles.controller;

import jakarta.validation.Valid;
import org.example.ex_meubles.entity.CartItem;
import org.example.ex_meubles.entity.Furniture;
import org.example.ex_meubles.service.CartService;
import org.example.ex_meubles.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/furnitures")
public class FurnitureController {

    private final FurnitureService furnitureService;


    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/list")
    public String furnituresPage(Model model){
        List<Furniture> furnitures = furnitureService.getAllFurniture();
        model.addAttribute("errMessage", "");
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("furnitures",furnitures);
        return "furnitures";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("furniture",new Furniture());
        return "furniture";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("furniture") Furniture furniture){
        furnitureService.saveFurniture(furniture);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")Long id){
        furnitureService.delete(furnitureService.getFurnitureById(id));
        return "redirect:/list";
    }
}
