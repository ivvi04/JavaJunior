package ru.lakeevda.lesson4.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lakeevda.lesson4.entity.Courses;

public class SessionHibernate {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Courses.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
