package com.example.graphql.service;

import com.example.graphql.entity.Author;
import com.example.graphql.entity.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book createBook(String title, Integer authorId, String publishedDate) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found with id " + authorId));
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(publishedDate);
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, String title, Integer authorId, String publishedDate) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found with id " + authorId));
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(publishedDate);
        return bookRepository.save(book);
    }

    public boolean deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return true;
    }
}
