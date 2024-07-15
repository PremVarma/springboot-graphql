package com.example.graphql;

import com.example.graphql.entity.Author;
import com.example.graphql.entity.Product;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GraphqlApplication {

//    @Autowired
//    private AuthorRepository authorRepository;
//
//
//    @PostConstruct
//    public void initDB() {
//        List<Author> products = Stream.of(
//                new Author("Prem Varma", "I am author of graphqa demo project", null),
//                new Author("Abhijit Kushwaha", "I am author of time management", null),
//                new Author("Ritesh Prasad", "I am author of ego disaster", null)
//        ).toList();
//        authorRepository.saveAll(products);
//    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }

}
