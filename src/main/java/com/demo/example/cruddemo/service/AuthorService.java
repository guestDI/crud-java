package com.demo.example.cruddemo.service;

import com.demo.example.cruddemo.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(int id);
    Author update(Author author);
    void delete(Author author);
}
