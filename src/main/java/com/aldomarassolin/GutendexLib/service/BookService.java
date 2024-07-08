package com.aldomarassolin.GutendexLib.service;

import com.aldomarassolin.GutendexLib.model.Book;
import com.aldomarassolin.GutendexLib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book salvarLivro(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> listarLivros() {
        return bookRepository.findAll();
    }

    public Book buscarLivroPorId(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deletarLivro(Long id) {
        bookRepository.deleteById(id);
    }
}

