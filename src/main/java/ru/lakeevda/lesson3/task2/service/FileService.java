package ru.lakeevda.lesson3.task2.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.lakeevda.lesson3.task2.enums.FileExtension;

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
        this.type = type;
    }

    public String getFileName(FileExtension fileExtension) {
        return this.path + this.type.getSimpleName() + "." + fileExtension.getExtension();
    }

    public void saveToFile(FileExtension fileExtension, List<T> list) {
        String fileName = getFileName(fileExtension);
        try {
            switch (fileExtension) {
                case FILE_JSON -> {
                    this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                    this.objectMapper.writeValue(new File(fileName), list);
                }
                case FILE_BIN -> {
                    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                        objectOutputStream.writeObject(list);
                    }
                }
                case FILE_XML -> this.xmlMapper.writeValue(new File(fileName), list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> loadFromFile(FileExtension fileExtension) {
        List<T> list = new ArrayList<>();
        String fileName = getFileName(fileExtension);
        File file = new File(fileName);
        if (file.exists()) {
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            CollectionType collectionType = typeFactory.constructCollectionType(ArrayList.class, type);
            try {
                switch (fileExtension) {
                    case FILE_JSON -> list = this.objectMapper.readValue(file, collectionType);
                    case FILE_BIN -> {
                        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                            list = (List<T>) objectInputStream.readObject();
                        }
                    }
                    case FILE_XML -> list = this.xmlMapper.readValue(file, collectionType);
                }
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
