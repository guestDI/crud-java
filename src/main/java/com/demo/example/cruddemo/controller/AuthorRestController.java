package com.demo.example.cruddemo.controller;

import com.demo.example.cruddemo.dao.AuthorDAO;
import com.demo.example.cruddemo.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class AuthorRestController {

    @Autowired
    AuthorDAO authorDAO;

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorDAO.findAll();
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        Author author = authorDAO.findById(authorId);
        if(authorId < 1 || author == null) {
            throw new AuthorNotFoundException("Author with id = " + authorId + " is not found");
        }

        return author;
    }

    @ExceptionHandler
    public ResponseEntity<AuthorErrorResponse> handleException(AuthorNotFoundException ex){

        AuthorErrorResponse error = new AuthorErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<AuthorErrorResponse> handleException(Exception ex){

        AuthorErrorResponse error = new AuthorErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
