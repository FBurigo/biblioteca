package com.uniamerica.livros.app.Biblioteca.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uniamerica.livros.app.Biblioteca.entity.Autor;
import com.uniamerica.livros.app.Biblioteca.service.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {
        return new ResponseEntity<>(autorService.save(autor), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll() {
        return new ResponseEntity<>(autorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Long id) {
        Autor autor = autorService.findById(id);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        autorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Autor>> findByNome(@RequestParam String nome) {
        return new ResponseEntity<>(autorService.findByNome(nome), HttpStatus.OK);
    }
}
