package ru.lakeevda.lesson3.task2;

import ru.lakeevda.lesson3.task2.entity.Student;
import ru.lakeevda.lesson3.task2.enums.FileExtension;
import ru.lakeevda.lesson3.task2.service.FileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Student> studentList;

        try (FileService<Student> fileService = new FileService<>(Student.class);) {
            File file = new File(fileService.getFileName(FileExtension.FILE_JSON));
            if (file.exists() && !file.isDirectory())
                studentList = fileService.loadFromFile(FileExtension.FILE_JSON);
            else studentList = initStudentList();
        }

        for (Student student : studentList) {
            System.out.println("Имя: " + student.getName());
            System.out.println("Возраст: " + student.getAge());
            System.out.println("Средний бал: " + student.getGPA());
        }

        try (FileService<Student> fileService = new FileService<>(Student.class);) {
            fileService.saveToFile(FileExtension.FILE_JSON, studentList);
            fileService.saveToFile(FileExtension.FILE_BIN, studentList);
            fileService.saveToFile(FileExtension.FILE_XML, studentList);
        }
    }

    private static List<Student> initStudentList() {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("Денис", 34, 4.0);
        studentList.add(student1);
        Student student2 = new Student("Анна", 32, 4.6);
        studentList.add(student2);
        return studentList;
    }
}
