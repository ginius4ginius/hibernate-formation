package com.formation.dao;

import com.formation.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookDaoSessionFactory implements BookDao {

    private SessionFactory sessionFactory;

    public void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // récupère la configuration du fichier hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void exit() {
        sessionFactory.close();
    }



    public void create() {

        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPrice(32.59f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();
        session.close();

    }

    public void read() {

        Session session = sessionFactory.openSession();

        long bookId = 8;
        Book book = session.get(Book.class, bookId);

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());

        session.close();

    }

    public void update() {

        Book book = new Book();
        book.setId(8);
        book.setTitle("Ultimate Java Programming");
        book.setAuthor("Nam Ha Minh");
        book.setPrice(19.99f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(book);

        session.getTransaction().commit();
        session.close();

    }

    public void delete() {

        Book book = new Book();
        book.setId(8);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(book);

        session.getTransaction().commit();
        session.close();

    }

}
