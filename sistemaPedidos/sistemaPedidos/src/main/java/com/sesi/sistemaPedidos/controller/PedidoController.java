package com.sesi.sistemaPedidos.controller;

import com.sesi.sistemaPedidos.model.Pedido;
import com.sesi.sistemaPedidos.model.StatusEnum; // Não esqueça de importar
import com.sesi.sistemaPedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedidos/novo")
    public String novoPedido() {
        return "novo-pedido"; // retorna o HTML novo-pedido.html
    }

    @PostMapping("/pedidos/salvar")
    public String salvarPedido(@RequestParam String produto, 
                               @RequestParam int quantidade, 
                               @RequestParam String data, 
                               @RequestParam String status) {
        Pedido novoPedido = new Pedido();
        novoPedido.setProduto(produto);
        novoPedido.setQuantidade(quantidade);
        novoPedido.setData(LocalDate.parse(data));
        novoPedido.setStatus(StatusEnum.valueOf(status)); // Converte a String para StatusEnum

        pedidoRepository.save(novoPedido); // Método para salvar o pedido
        return "redirect:/produtos"; // Redireciona para a lista de produtos após salvar
    }
}
