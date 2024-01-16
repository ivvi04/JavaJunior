package ru.lakeevda.lesson3.task2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.lakeevda.lesson3.task2.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService implements Closeable {
    private final XmlMapper xmlMapper;
    private final ObjectMapper objectMapper;

    public FileService() {
        this.objectMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();
        objectMapper.registerModule(new JavaTimeModule());
        xmlMapper.registerModule(new JavaTimeModule());
    }

    public void saveToFile(String fileName, List<Student> studentList) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), studentList);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    objectOutputStream.writeObject(studentList);
                }
            } else if (fileName.endsWith(".xml")) xmlMapper.writeValue(new File(fileName), studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> loadFromFile(String fileName) {
        List<Student> studentList = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json"))
                    studentList = objectMapper.readValue(file, objectMapper.getTypeFactory()
                            .constructCollectionType(List.class, Student.class));
                else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                        studentList = (List<Student>) objectInputStream.readObject();
                    }
                } else if (fileName.endsWith(".xml"))
                    studentList = xmlMapper.readValue(file, xmlMapper.getTypeFactory()
                            .constructCollectionType(List.class, Student.class));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return studentList;
    }

    @Override
    public void close() throws IOException {

    }
}
