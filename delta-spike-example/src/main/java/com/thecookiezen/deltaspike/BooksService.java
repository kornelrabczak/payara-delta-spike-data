package com.thecookiezen.deltaspike;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BooksService {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveNewEntity() {
        Book testEntity = new Book();
        testEntity.setTitle("test");
        entityManager.persist(testEntity);
    }
}
