package com.uniamerica.livros.app.Biblioteca.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uniamerica.livros.app.Biblioteca.entity.Livro;
import com.uniamerica.livros.app.Biblioteca.entity.Editora;
import com.uniamerica.livros.app.Biblioteca.service.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/save")
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        return new ResponseEntity<>(livroService.save(livro), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> findAll() {
        return new ResponseEntity<>(livroService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        if (livro != null) {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        livroService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/findByTitulo")
    public ResponseEntity<List<Livro>> findByTitulo(@RequestParam String titulo) {
        return new ResponseEntity<>(livroService.findByTitulo(titulo), HttpStatus.OK);
    }


    @GetMapping("/findByParteDoNome")
    public ResponseEntity<List<Livro>> findByParteDoNome(@RequestParam String titulo) {
        return new ResponseEntity<>(livroService.findByParteDoNome(titulo), HttpStatus.OK);
    }


    @GetMapping("/findByEditora")
    public ResponseEntity<List<Livro>> findByEditora(@RequestParam Long editoraId) {
        Editora editora = new Editora();
        editora.setId(editoraId);
        return new ResponseEntity<>(livroService.findByEditora(editora), HttpStatus.OK);
    }


    @GetMapping("/findAbaixoAno")
    public ResponseEntity<List<Livro>> findAbaixoAno(@RequestParam int ano) {
        return new ResponseEntity<>(livroService.findAbaixoAno(ano), HttpStatus.OK);
    }
}
