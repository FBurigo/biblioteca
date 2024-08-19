package com.uniamerica.livros.app.Biblioteca.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uniamerica.livros.app.Biblioteca.entity.Editora;
import com.uniamerica.livros.app.Biblioteca.service.EditoraService;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @PostMapping("/save")
    public ResponseEntity<Editora> save(@RequestBody Editora editora) {
        return new ResponseEntity<>(editoraService.save(editora), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Editora>> findAll() {
        return new ResponseEntity<>(editoraService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Long id) {
        Editora editora = editoraService.findById(id);
        if (editora != null) {
            return new ResponseEntity<>(editora, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        editoraService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Editora>> findByNome(@RequestParam String nome) {
        return new ResponseEntity<>(editoraService.findByNome(nome), HttpStatus.OK);
    }
}
