package com.demo.example.cruddemo.controller;

import com.demo.example.cruddemo.dao.AuthorDAO;
import com.demo.example.cruddemo.entity.Author;
import com.demo.example.cruddemo.service.AuthorService;
import com.demo.example.cruddemo.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class AuthorRestController {

    private AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService theAuthorService){
        authorService = theAuthorService;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable int authorId) {
        Author author = authorService.findById(authorId);
        if(author == null ){
            throw new AuthorNotFoundException("Author with id = " + authorId + " is not found");
        }
        authorService.delete(author);
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.update(author);
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        Author author = authorService.findById(authorId);
        if(authorId < 1 || author == null) {
            throw new AuthorNotFoundException("Author with id = " + authorId + " is not found");
        }

        return author;
    }
}
