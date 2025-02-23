package com.example.libraryApp.controllers;

import com.example.libraryApp.models.Book;
import com.example.libraryApp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BooksController {

    private final BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        List<Book> books = bookService.findAll();
        logger.info("Returning {} books", books.size()); // Логируем количество книг, которые возвращаются в ответе
        return books;
    }


}
