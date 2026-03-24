package com.atividade.vet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atividade.vet.model.Animal;
import com.atividade.vet.model.Usuario;
import com.atividade.vet.repository.AnimalRepository;
import com.atividade.vet.repository.UsuarioRepository;


@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/")
    public String formsUsuario(Model model){
        model.addAttribute("usuarios", new Usuario());

        List<Animal> animais = animalRepository.findAll();
        model.addAttribute("animais", animais);

        return "usuario/formUsuario";
    }
    
    @GetMapping("/usuarios")
    public String listaUsuarios(@RequestParam(required = false) String nome, Model model){
        List<Usuario> usuarios;
        if (nome != null && !nome.isEmpty()) {
            usuarios = usuarioRepository.findByNome(nome);
        } else {
            usuarios = usuarioRepository.findAll();
        }
        model.addAttribute("usuarios", usuarios);
        return "usuario/listaUsuarios";
    }

    @PostMapping("/salvarUsuario")
    public String salvarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/deletarUsuario")
    public String deletarUsuario(@RequestParam Long id){
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}
