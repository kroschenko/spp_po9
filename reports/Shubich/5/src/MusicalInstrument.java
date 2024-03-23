package org.example;

public abstract class MusicalInstrument {
    private String name;

    public MusicalInstrument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void play() {
        System.out.println("Играет: " + name);
    }
    @Override
    public String toString() {
        return "Название: " + name;
    }

    public abstract void tune();
}
