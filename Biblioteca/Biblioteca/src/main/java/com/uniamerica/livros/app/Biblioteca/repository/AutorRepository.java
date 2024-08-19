package com.uniamerica.livros.app.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uniamerica.livros.app.Biblioteca.entity.Autor;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNome(String nome);
}
