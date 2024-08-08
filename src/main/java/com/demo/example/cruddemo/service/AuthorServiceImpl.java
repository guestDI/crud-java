package com.demo.example.cruddemo.service;

import com.demo.example.cruddemo.dao.AuthorDAO;
import com.demo.example.cruddemo.dao.AuthorRepository;
import com.demo.example.cruddemo.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository theAuthorRepository){
        authorRepository = theAuthorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int id) {
        Optional<Author> result = authorRepository.findById(id);
        Author author = null;

        if(result.isPresent()){
            author = result.get();
        } else {
            throw new RuntimeException("No author found");
        }

        return author;
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Author author) {
        authorRepository.delete(author);
    }
}
