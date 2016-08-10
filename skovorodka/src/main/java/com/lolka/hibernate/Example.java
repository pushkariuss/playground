package com.lolka.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by pushkariuss on 08.07.2016.
 */
public class Example {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
    }
}
