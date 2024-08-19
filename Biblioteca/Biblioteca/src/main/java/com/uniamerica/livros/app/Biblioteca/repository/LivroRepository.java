package com.uniamerica.livros.app.Biblioteca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uniamerica.livros.app.Biblioteca.entity.Livro;
import com.uniamerica.livros.app.Biblioteca.entity.Editora;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByTitulo(String titulo);

    @Query("SELECT l FROM Livro l WHERE l.titulo LIKE %:titulo%")
    List<Livro> findByParteDoNome(@Param("titulo") String titulo);

    List<Livro> findByEditora(Editora editora);

    @Query("SELECT l FROM Livro l WHERE l.ano < :ano")
    List<Livro> findAbaixoAno(@Param("ano") int ano);
}
