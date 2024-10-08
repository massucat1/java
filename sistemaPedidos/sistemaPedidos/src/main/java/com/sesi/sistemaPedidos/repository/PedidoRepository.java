package com.sesi.sistemaPedidos.repository;

import com.sesi.sistemaPedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Métodos adicionais, se necessário
}
