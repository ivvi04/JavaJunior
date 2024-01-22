package ru.lakeevda.lesson4.repository;

import ru.lakeevda.lesson4.entity.Courses;

import java.util.List;

public interface CoursesRepository {
        public List<Courses> getAllCourses();
        public Courses getCourse(Integer id);
        public void saveCourse(Courses courses);
        public void deleteCourse(Integer id);
}
