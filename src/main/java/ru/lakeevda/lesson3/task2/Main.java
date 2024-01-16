package ru.lakeevda.lesson3.task2;

import ru.lakeevda.lesson3.task2.student.entity.Student;
import ru.lakeevda.lesson3.task2.student.services.FileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String FILE_JSON = "./data/student.json";
    public static String FILE_XML = "./data/student.xml";
    public static String FILE_BIN = "./data/student.bin";

    public static void main(String[] args) throws IOException {
        List<Student> studentList;

        try (FileService fileService = new FileService();) {
            File file = new File(FILE_JSON);
            if (file.exists() && !file.isDirectory()) studentList = fileService.loadFromFile(FILE_JSON);
            else studentList = initStudentList();
        }

        for (Student student : studentList) {
            System.out.println("Имя: " + student.getName());
            System.out.println("Возраст: " + student.getAge());
            System.out.println("Средний бал: " + student.getGPA());
        }

        try (FileService fileService = new FileService();) {
            fileService.saveToFile(FILE_JSON, studentList);
            fileService.saveToFile(FILE_BIN, studentList);
            fileService.saveToFile(FILE_XML, studentList);
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
