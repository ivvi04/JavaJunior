package ru.lakeevda.lesson4;

import ru.lakeevda.lesson4.entity.Courses;
import ru.lakeevda.lesson4.services.CoursesService;
import ru.lakeevda.lesson4.services.CoursesServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Courses courses1 = new Courses("Java Junior (лекции)", 5);
        Courses courses2 = new Courses("Java Junior (семинары)", 5);
        CoursesService coursesService = new CoursesServiceImpl();
        coursesService.saveCourse(courses1);
        System.out.println(courses1.toString());
        coursesService.saveCourse(courses2);
        System.out.println(courses2.toString());

        courses1 = coursesService.getCourse(courses1.getId());
        courses1.setDuration(6);
        coursesService.saveCourse(courses1);
        System.out.println(courses1.toString());

        coursesService.deleteCourse(courses1.getId());

        List<Courses> coursesList = coursesService.getAllCourses();
        System.out.println(coursesList);
    }
}
