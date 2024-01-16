package ru.lakeevda.lesson3.task1;

import ru.lakeevda.lesson3.task1.entity.Student;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "./data/Student.bin";
        Student student1 = new Student("Денис", 34, 4.0);
        Student student2 = new Student("Анна", 32, 4.6);

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student1);
            System.out.println("Объект student1 сериализован");
            objectOutputStream.writeObject(student2);
            System.out.println("Объект student2 сериализован");
        }

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student1 = (Student) objectInputStream.readObject();
            System.out.println("Объект student1 десериализован");
            student2 = (Student) objectInputStream.readObject();
            System.out.println("Объект student2 десериализован");
        }

        System.out.println("Объект student1");
        System.out.println("Имя: " + student1.getName());
        System.out.println("Возраст: " + student1.getAge());
        System.out.println("Средний бал: " + student1.getGPA());

        System.out.println("Объект student2");
        System.out.println("Имя: " + student2.getName());
        System.out.println("Возраст: " + student2.getAge());
        System.out.println("Средний бал: " + student2.getGPA());

        /**
         * Transient-свойства не входят в состав обычного определения класса, они считаются временными
         * и не являются частью состояния объекта. Поэтому GPA не было сериализовано
         */
    }

}
