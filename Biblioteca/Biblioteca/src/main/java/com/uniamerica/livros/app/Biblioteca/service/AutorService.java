package com.uniamerica.livros.app.Biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniamerica.livros.app.Biblioteca.entity.Autor;
import com.uniamerica.livros.app.Biblioteca.repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor findById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    public List<Autor> findByNome(String nome) {
        return autorRepository.findByNome(nome);
    }
}
