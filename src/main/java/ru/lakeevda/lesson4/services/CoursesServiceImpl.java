package ru.lakeevda.lesson4.services;

import ru.lakeevda.lesson4.entity.Courses;
import ru.lakeevda.lesson4.repository.CoursesRepository;
import ru.lakeevda.lesson4.repository.CoursesRepositoryImpl;

import java.util.List;

public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepository coursesRepository = new CoursesRepositoryImpl();

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.getAllCourses();
    }

    @Override
    public Courses getCourse(Integer id) {
        return coursesRepository.getCourse(id);
    }

    @Override
    public void saveCourse(Courses courses) {
        coursesRepository.saveCourse(courses);
    }

    @Override
    public void deleteCourse(Integer id) {
        coursesRepository.deleteCourse(id);
    }
}
