package com.sesi.sistemaPedidos;

import com.sesi.sistemaPedidos.model.Produto;
import com.sesi.sistemaPedidos.model.Usuario;
import com.sesi.sistemaPedidos.model.Pedido;
import com.sesi.sistemaPedidos.model.StatusEnum;
import com.sesi.sistemaPedidos.model.TipoUsuarioEnum;
import com.sesi.sistemaPedidos.repository.ProdutoRepository;
import com.sesi.sistemaPedidos.repository.UsuarioRepository;
import com.sesi.sistemaPedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Adicionando um produto
        Produto produto = new Produto();
        produto.setNome("Produto 1");
        produto.setEstoque(50);
        produto.setPreco(19.99f);
        produtoRepository.save(produto);

        // Adicionando um usuário
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setTelefone("123456789");
        usuario.setTipoUsuario(TipoUsuarioEnum.FUNCIONARIO);
        usuarioRepository.save(usuario);

        // Adicionando um pedido
        Pedido pedido = new Pedido();
        pedido.setProduto(produto.getNome()); // Usar o nome do produto
        pedido.setQuantidade(2);
        pedido.setData(LocalDate.now());
        pedido.setValor(produto.getPreco() * pedido.getQuantidade()); // Cálculo do valor
        pedido.setStatus(StatusEnum.ABERTO); // Definindo o status como StatusEnum
        pedidoRepository.save(pedido);
    }
}
