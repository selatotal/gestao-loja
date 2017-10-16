package br.edu.ulbra.gestaoloja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("/{produtoId}")
    public String listarProduto(@PathVariable Integer produtoId){
        return "listarProduto";
    }
}
