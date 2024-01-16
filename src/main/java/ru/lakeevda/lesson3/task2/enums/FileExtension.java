package ru.lakeevda.lesson3.task2.enums;

public enum FileExtension {
    FILE_JSON ("json"),
    FILE_XML ("xml"),
    FILE_BIN ("bin");

    private final String extension;
    FileExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
