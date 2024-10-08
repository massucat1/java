package com.sesi.sistemaPedidos.repository;

import com.sesi.sistemaPedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
