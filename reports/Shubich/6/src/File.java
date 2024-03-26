package org.example;

public class File implements FileSystemComponent {
    private String name;
    private int size;
    private String extension;
    private String createdDate;

    public File(String name, int size, String extension, String createdDate) {
        this.name = name;
        this.size = size;
        this.extension = extension;
        this.createdDate = createdDate;
    }

    @Override
    public void showInfo() {
        System.out.println("File: " + name + "." + extension + ", Size: " + size + " bytes, Created: " + createdDate);
    }
}