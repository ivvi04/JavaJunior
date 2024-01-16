package ru.lakeevda.lesson3.task2.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService<T> implements Closeable {
    private final String path = "./data/";
    private final XmlMapper xmlMapper;
    private final ObjectMapper objectMapper;
    private final Class<T> type;

    public FileService(Class<T> type) {
        this.objectMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();
        objectMapper.registerModule(new JavaTimeModule());
        xmlMapper.registerModule(new JavaTimeModule());
        this.type = type;
    }

    public String getFileName(String fileExtension) {
        return this.path + this.type.getSimpleName() + "." + fileExtension;
    }

    public void saveToFile(String fileExtension, List<T> list) {
        String fileName = getFileName(fileExtension);
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), list);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    objectOutputStream.writeObject(list);
                }
            } else if (fileName.endsWith(".xml")) xmlMapper.writeValue(new File(fileName), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> loadFromFile(String fileExtension) {
        List<T> list = new ArrayList<>();

        String fileName = getFileName(fileExtension);
        File file = new File(fileName);
        if (file.exists()) {
            TypeReference<List<T>> typeReference = new TypeReference<>() {
            };
            try {
                if (fileName.endsWith(".json"))
                    list = objectMapper.readValue(fileName, typeReference);
                else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                        list = (List<T>) objectInputStream.readObject();
                    }
                } else if (fileName.endsWith(".xml"))
                    list = xmlMapper.readValue(fileName, typeReference);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void close() throws IOException {

    }
}
