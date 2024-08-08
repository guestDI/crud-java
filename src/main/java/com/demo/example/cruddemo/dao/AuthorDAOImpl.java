package com.demo.example.cruddemo.dao;

import com.demo.example.cruddemo.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private EntityManager entityManager;

    @Autowired
    public AuthorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public Author findById(Integer authorId) {
        return entityManager.find(Author.class, authorId);
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> theQuery = entityManager.createQuery("FROM Author order by lastName", Author.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Author> findByLastname(String lastname) {
        TypedQuery<Author> theQuery = entityManager.createQuery("FROM Author WHERE lastName=:theData order by lastName", Author.class);

        theQuery.setParameter("theData", lastname);

        return theQuery.getResultList();
    }

    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author);
    }

    @Override
    public void deleteByLastName(String lastname) {
        Query theQuery = entityManager.createQuery("DELETE FROM Author WHERE lastName=:theData");

        theQuery.setParameter("theData", lastname)
                .executeUpdate();
    }


}
