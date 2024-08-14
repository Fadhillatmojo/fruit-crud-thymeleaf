package com.example.crudthymeleaf.controller;

import com.example.crudthymeleaf.model.Fruit;
import com.example.crudthymeleaf.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ApplicationController {
//    private final RestTemplate restTemplate;
    @Autowired
    private FruitService fruitService;
//
//    @Autowired
//    public ApplicationController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @GetMapping
//    public String getHomePage(Model model) {
//        String apiUrl = "http://localhost:8080/api/fruits"; // URL API
//        List<Object> fruits = restTemplate.getForObject(apiUrl, List.class);
//        model.addAttribute("fruits", fruits);
//        return "index";
//    }
    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("fruits", fruitService.getAllFruits());
        return "index"; // Nama template Thymeleaf untuk daftar buah
    }

    @GetMapping("/addFruit")
    public String getAddFruitPage() {
        return "add-form";
    }

    @PostMapping("/addFruit")
    public String createFruit(@ModelAttribute Fruit fruit) {
        fruitService.createFruit(fruit);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Fruit fruit = fruitService.getFruitById(id);
        model.addAttribute("fruit", fruit);
        return "update-form"; // Nama template Thymeleaf untuk halaman update
    }

    @PostMapping("/update/{id}")
    public String updateFruit(@PathVariable("id") int id, @ModelAttribute Fruit fruit) {
        fruitService.updateFruit(id, fruit);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteFruit(@PathVariable("id") int id) {
        fruitService.deleteFruit(id);
        return "redirect:/";
    }

//    // Metode untuk menangani permintaan POST dari form update
//    @PutMapping("/update/{id}")
//    public String updateFruit(@PathVariable("id") int id, @ModelAttribute("fruit") Fruit fruit) {
//        // Update data ke API
//        String apiUrl = "http://localhost:8080/api/fruits"; // URL API
//
//        restTemplate.put(apiUrl + "/" + id, fruit);
//        return "redirect:/"; // Redirect ke halaman utama setelah update
//    }
}
