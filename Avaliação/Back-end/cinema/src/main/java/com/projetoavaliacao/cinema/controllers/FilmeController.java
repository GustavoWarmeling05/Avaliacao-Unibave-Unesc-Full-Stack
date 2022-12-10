package com.projetoavaliacao.cinema.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetoavaliacao.cinema.entitites.Filme;
import com.projetoavaliacao.cinema.services.FilmeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/filmes")
public class FilmeController {
    
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/listar")
    public ResponseEntity<List<Filme>> listarFilme() {
        return ResponseEntity.status(200).body(filmeService.listarFilme());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Filme> criarFilme(@RequestBody Filme filme) {
        return ResponseEntity.status(201).body(filmeService.criarFilme(filme));
    }

    @PutMapping("/editar")
    public ResponseEntity<Filme> editarFilme(@RequestBody Filme filme) {
        return ResponseEntity.status(200).body(filmeService.editarFilme(filme));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<?> excluirFilme(@PathVariable Long id) {
        filmeService.excluirFilme(id);
        return ResponseEntity.status(204).build();
    }  
}
