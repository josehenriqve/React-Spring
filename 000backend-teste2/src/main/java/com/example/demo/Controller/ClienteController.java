package com.example.demo.Controller;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:3000/")
public class ClienteController {
    @Autowired
    ClienteRepository repository;
    @GetMapping(value = "listar")
    public List<Cliente> listar(){
        return repository.findAll();
    }

    @PostMapping(value="cadastrar")
    public ResponseEntity<Cliente> cadatrar(@RequestBody Cliente cliente){
        repository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }
    @DeleteMapping(value="deletar/{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().body(null);
    }
    @PutMapping(value = "modificar")
    public ResponseEntity<Cliente> modificar(@RequestBody Cliente cliente){
        if (repository.existsById(cliente.getId())) {
            repository.save(cliente);
            return ResponseEntity.ok().body(cliente);
        }
        return ResponseEntity.ok().body(null);
    }
}
