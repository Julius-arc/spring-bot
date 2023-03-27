package com.api.modelo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.modelo.cadastro.Cliente;
import com.api.modelo.repositorio.ClienteRepositorio;



@RestController
@RequestMapping("/ap1/v1/Cliente")
public class ClienteControle {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

	@GetMapping
    public List<Cliente> listar() {
        return clienteRepositorio.findAll();
    }
	
	   @GetMapping("/{id}")
	    public Cliente buscarPorId(@PathVariable Long id) {
	        var clienteOptional = clienteRepositorio.findById(id);
	        if (clienteOptional.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        }
	        return clienteOptional.get();
	    }
	   
	   @DeleteMapping("/{id}")
	    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	    public void excluirPorId(@PathVariable Long id) {
	        var clienteOptional = clienteRepositorio.findById(id);
	        if (clienteOptional.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        }
	        clienteRepositorio.delete(clienteOptional.get());
	    }
	   
	   @PutMapping("/{id}")
	    public Cliente atualizarPorId(@PathVariable Long id, @RequestBody Cliente cliente) {
	        var clienteOptional = clienteRepositorio.findById(id);
	        if (clienteOptional.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        }
	        cliente.setId(id);
	        return clienteRepositorio.save(cliente);
	    }
	   

}
