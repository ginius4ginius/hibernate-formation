package com.formation.dao;

import com.formation.entities.Book;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookDaoEntityManagerFactory implements BookDao {


    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BooksDB");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public void exit() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public void create() {
        Book book = new Book();
        book.setTitle("Java on web");
        book.setAuthor("Vincent Derieu");
        book.setPrice(25.00f);

        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public void read() {

        long bookId = 10;
        Book book = entityManager.find(Book.class, bookId);

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());

    }

    public void update() {
        Book book = new Book();
        book.setId(10);
        book.setTitle("Java on web V2");
        book.setAuthor("Vincent Derieu");
        book.setPrice(35.50f);

        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }

    public void delete() {
        long primaryKey = 10;
        Book reference = entityManager.getReference(Book.class, primaryKey);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();
    }
}
