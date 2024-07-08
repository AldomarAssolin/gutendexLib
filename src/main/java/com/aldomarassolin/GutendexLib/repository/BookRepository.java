package com.aldomarassolin.GutendexLib.repository;

import com.aldomarassolin.GutendexLib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Métodos adicionais específicos podem ser adicionados aqui, se necessário
}
