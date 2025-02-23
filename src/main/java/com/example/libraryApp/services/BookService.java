package com.example.libraryApp.services;

import com.example.libraryApp.models.Book;
import com.example.libraryApp.repositories.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BooksRepository booksRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        List<Book> books = booksRepository.findAll();
        logger.info("Books found: {}", books.size()); // Логируем количество найденных книг
        books.forEach(book -> logger.info("Book: {}", book)); // Логируем каждую книгу
        return books;
    }

    public Book findOne(int id) {
        Optional<Book> book = booksRepository.findById(id);
        return book.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

//    @Transactional
//    public void update(int id, Book updatedBook) {
//        updatedBook.setId(id);
//        booksRepository.save(updatedBook);
//    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }
}
