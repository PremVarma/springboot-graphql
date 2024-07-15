package com.example.graphql.resource;

import com.example.graphql.entity.Author;
import com.example.graphql.entity.Book;
import com.example.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookResolver {
    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id) {
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument Integer authorId, @Argument String publishedDate) {
        return bookService.createBook(title, authorId, publishedDate);
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument String title, @Argument Integer authorId, @Argument String publishedDate) {
        return bookService.updateBook(id, title, authorId, publishedDate);
    }

    @MutationMapping
    public boolean deleteBook(@Argument Integer id) {
        return bookService.deleteBook(id);
    }
}
