package ru.lakeevda.lesson3.task2.student.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@Data
@NoArgsConstructor
public class Student implements Externalizable {
    private String name;
    private int age;
    private double GPA;
    @Serial
    private static final long serialVersionUID = 1L;
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getAge());
        out.writeObject(this.getGPA());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        GPA = in.readDouble();
    }
}
