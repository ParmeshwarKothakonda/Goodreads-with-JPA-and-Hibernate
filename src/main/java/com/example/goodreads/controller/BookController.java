package com.example.goodreads.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.goodreads.model.Book;
// import com.example.goodreads.service.BookH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.goodreads.service.BookJpaService;

import java.util.*;

@RestController
class BookController {
    @Autowired
    // public BookH2Service bookService;
    public BookJpaService bookService; //changing it to JpaService

    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    
    @PostMapping("/books/bulk")
    public String addMultipleBooks(@RequestBody ArrayList<Book> multipleBooks) {
    	return bookService.addMultipleBooks(multipleBooks);
    }
    
    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }
    
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }


}
