package com.formation.dao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {


    private   SessionFactory sessionFactory;


    public SessionFactoryUtils()
    {
        setup();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private  void setup() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void exit() {
        sessionFactory.close();
    }

}
