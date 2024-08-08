package com.demo.example.cruddemo.dao;

import com.demo.example.cruddemo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
//    Author update(Author author);
}
