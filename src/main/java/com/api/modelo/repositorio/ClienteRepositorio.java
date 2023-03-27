 package com.api.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.modelo.cadastro.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
