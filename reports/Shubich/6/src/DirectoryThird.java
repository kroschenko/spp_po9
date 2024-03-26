package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DirectoryThird implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public DirectoryThird(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void showInfo() {
        System.out.println("Directory: " + name);
        List<FileSystemComponent> shuffledChildren = new ArrayList<>(children);
        Collections.shuffle(shuffledChildren);
        for (FileSystemComponent child : shuffledChildren) {
            child.showInfo();
        }

    }
}
