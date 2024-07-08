//package com.aldomarassolin.GutendexLib.controller;
//
//import com.aldomarassolin.GutendexLib.model.Book;
//import com.aldomarassolin.GutendexLib.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;

//@RestController
//@RequestMapping("/books")
//public class BookController {
//    @Autowired
//    private BookService bookService;
//
//    @GetMapping("/search")
//    public List<Book> searchBooksByTitle(@RequestParam String title) {
//        return bookService.searchBooksByTitle(title);
//    }
//
//    @GetMapping
//    public List<Book> listAllBooks() {
//        return bookService.listAllBooks();
//    }
//
//    @GetMapping("/language")
//    public List<Book> listBooksByLanguage(@RequestParam String language) {
//        return bookService.listBooksByLanguage(language);
//    }
//
//    @PostMapping
//    public Book saveBook(@RequestBody Book book) {
//        return bookService.saveBook(book);
//    }
//}
