package com.demo.example.cruddemo.dao;

import com.demo.example.cruddemo.entity.Author;

import java.util.List;

public interface AuthorDAO {
    void save(Author author);
    Author findById(Integer id);
    List<Author> findAll();
    List<Author> findByLastname(String lastname);
    void update(Author author);
    void delete(Integer id);
    void deleteByLastName(String lastname);
}
