package org.example;
import java.util.ArrayList;
import java.util.List;
// Композит (Директория)
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(FileSystemComponent child) {
        children.add(child);
    }

    public void removeChild(FileSystemComponent child) {
        children.remove(child);
    }

    @Override
    public void showInfo() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent child : children) {
            child.showInfo();
        }
    }
}