package com.aldomarassolin.GutendexLib.repository;

import com.aldomarassolin.GutendexLib.model.Book;
import com.aldomarassolin.GutendexLib.model.DadosBooks;
import com.aldomarassolin.GutendexLib.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT p FROM Book b JOIN b.authors p")
    List<Person> listarAutores();

}
