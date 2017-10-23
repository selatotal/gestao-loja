package br.edu.ulbra.gestaoloja.controller;

import br.edu.ulbra.gestaoloja.model.User;
import br.edu.ulbra.gestaoloja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(){
        List<User> usuarios = (List<User>)userRepository.findAll();
        for(User usuario : usuarios){
            System.out.println(usuario.getUsername());
        }
        return "admin/index";
    }

    @PostMapping(value="/login")
    public String login(){
        return "admin/login";
    }
}
