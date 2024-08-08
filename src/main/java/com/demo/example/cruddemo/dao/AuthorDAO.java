package com.demo.example.cruddemo.dao;

import com.demo.example.cruddemo.entity.Author;

import java.util.List;

public interface AuthorDAO {
    void save(Author author);
    Author findById(Integer id);
    List<Author> findAll();
    List<Author> findByLastname(String lastname);
    Author update(Author author);
    void delete(Author author);
    void deleteByLastName(String lastname);
}
