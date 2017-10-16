package br.edu.ulbra.gestaoloja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by talesviegas on 09/10/17.
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @PostMapping(value="/login")
    public String login(){
        return "admin/login";
    }
}
