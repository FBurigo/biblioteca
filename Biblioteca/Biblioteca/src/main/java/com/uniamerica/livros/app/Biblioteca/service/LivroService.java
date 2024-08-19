package com.uniamerica.livros.app.Biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniamerica.livros.app.Biblioteca.entity.Livro;
import com.uniamerica.livros.app.Biblioteca.entity.Editora;
import com.uniamerica.livros.app.Biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> findByTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }

    public List<Livro> findByParteDoNome(String titulo) {
        return livroRepository.findByParteDoNome(titulo);
    }

    public List<Livro> findByEditora(Editora editora) {
        return livroRepository.findByEditora(editora);
    }

    public List<Livro> findAbaixoAno(int ano) {
        return livroRepository.findAbaixoAno(ano);
    }
}
