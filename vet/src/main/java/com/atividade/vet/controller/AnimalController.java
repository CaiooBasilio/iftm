package com.atividade.vet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atividade.vet.model.Animal;
import com.atividade.vet.repository.AnimalRepository;

import org.springframework.ui.Model;

@Controller
public class AnimalController {
    
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/animais")
    public String listaAnimais(Model model){
        model.addAttribute("animais", new Animal());
        return "animal/listaAnimais";
    }

    @PostMapping("/salvarAnimal")
    public String salvarAnimal(Animal animal){
        animalRepository.save(animal);
        return "redirect:/animais";
    }

    @GetMapping("/deletarAnimal")
    public String deletarAnimal(@RequestParam Long id){
        animalRepository.deleteById(id);
        return "redirect:/animais";
    }
}
