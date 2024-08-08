package com.demo.example.cruddemo.service;

import com.demo.example.cruddemo.dao.AuthorDAO;
import com.demo.example.cruddemo.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorDAO authorDAO;
    public AuthorServiceImpl(AuthorDAO theAuthorDAO){
        authorDAO = theAuthorDAO;
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public Author findById(int id) {
        return authorDAO.findById(id);
    }

    @Override
    @Transactional
    public Author update(Author author) {
        return authorDAO.update(author);
    }

    @Override
    @Transactional
    public void delete(Author author) {
        authorDAO.delete(author);
    }
}
