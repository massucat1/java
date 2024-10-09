package com.sesi.sistemaPedidos.controller;

import com.sesi.sistemaPedidos.model.Produto;
import com.sesi.sistemaPedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos") // Mapeia a rota para listar produtos
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll(); // Busca todos os produtos
        model.addAttribute("produtos", produtos); // Adiciona a lista de produtos ao modelo
        return "index"; // Retorna o HTML index.html
    }

    @GetMapping("/produtos/novo") // Alterado para evitar conflito
    public String novoProduto(Model model) {
        model.addAttribute("produto", new Produto()); // Adiciona um novo objeto Produto ao modelo
        return "novo-produto"; // Retorna o HTML novo-produto.html
    }

    @PostMapping("/produtos/salvar") // Alterado para evitar conflito
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto); // Salva o produto no banco de dados
        return "redirect:/produtos/index"; // Redireciona para a lista de produtos após salvar
    }
}
