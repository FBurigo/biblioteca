package com.uniamerica.livros.app.Biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniamerica.livros.app.Biblioteca.entity.Editora;
import com.uniamerica.livros.app.Biblioteca.repository.EditoraRepository;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public Editora save(Editora editora) {
        return editoraRepository.save(editora);
    }

    public List<Editora> findAll() {
        return editoraRepository.findAll();
    }

    public Editora findById(Long id) {
        return editoraRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        editoraRepository.deleteById(id);
    }

    public List<Editora> findByNome(String nome) {
        return editoraRepository.findByNome(nome);
    }
}
