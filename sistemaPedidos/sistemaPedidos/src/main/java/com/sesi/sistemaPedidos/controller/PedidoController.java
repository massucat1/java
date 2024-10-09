package com.sesi.sistemaPedidos.controller;

import com.sesi.sistemaPedidos.model.Pedido;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @GetMapping("/novo")
    public String novoPedidoForm(Model model) {
        // Você pode passar dados para o modelo se necessário
        return "novo-pedido"; // Retorna o nome do arquivo HTML para o formulário
    }



    @PostMapping("/salvar")
    public String salvarPedido(@ModelAttribute Pedido pedido) {
        // lógica para salvar o pedido
        return "redirect:/pedidos"; // redireciona para a lista de pedidos, por exemplo
    

    }
}
