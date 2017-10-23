package br.edu.ulbra.gestaoloja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/produtos")
public class AdminProdutoController {

    @GetMapping("/")
    public String listarProdutos(){
        return "admin/produtos/index";
    }

    @GetMapping(value = "/novo")
    public String dadosNovoProduto(){
        return "admin/produtos/novo";
    }

    @PostMapping(value="/novo")
    public String incluirNovoProduto(){
        return "admin/produtos/novo";
    }

    @GetMapping(value="/{produtoId}")
    public String editarProduto(@PathVariable Integer produtoId){
        return "admin/produtos/editar";
    }

    @PostMapping(value="/{produtoId}")
    public String salvarProduto(@PathVariable Integer produtoId){
        return "admin/produtos/editar";
    }

    @DeleteMapping(value="/{produtoId}")
    public String excluirProduto(@PathVariable Integer produtoId){
        return "admin/produtos/excluir";
    }
}
