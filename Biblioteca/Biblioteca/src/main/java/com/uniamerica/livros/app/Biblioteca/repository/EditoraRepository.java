package com.uniamerica.livros.app.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uniamerica.livros.app.Biblioteca.entity.Editora;
import java.util.List;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    List<Editora> findByNome(String nome);
}
