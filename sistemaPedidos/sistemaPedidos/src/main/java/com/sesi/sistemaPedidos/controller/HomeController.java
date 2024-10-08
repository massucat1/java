package com.sesi.sistemaPedidos.controller;

import com.sesi.sistemaPedidos.model.Produto;
import com.sesi.sistemaPedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "index"; // Nome do arquivo HTML sem a extensão
    }
}
