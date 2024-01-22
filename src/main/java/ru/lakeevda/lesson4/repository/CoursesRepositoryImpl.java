package ru.lakeevda.lesson4.repository;

import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import ru.lakeevda.lesson4.entity.Courses;
import ru.lakeevda.lesson4.utils.SessionHibernate;

import java.util.List;

public class CoursesRepositoryImpl implements CoursesRepository {

    @Override
    public List<Courses> getAllCourses() {
        try (Session session = SessionHibernate.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Courses> coursesList = session.createSelectionQuery("from Courses ", Courses.class).list();
            session.getTransaction().commit();
            return coursesList;
        }
    }

    @Override
    public Courses getCourse(Integer id) {
        try (Session session = SessionHibernate.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Courses courses = session.get(Courses.class, id);
            session.getTransaction().commit();
            return courses;
        }
    }

    @Override
    public void saveCourse(Courses courses) {
        try (Session session = SessionHibernate.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            session.merge(courses);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteCourse(Integer id) {
        try (Session session = SessionHibernate.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            MutationQuery query = session.createMutationQuery("delete from Courses c where c.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
