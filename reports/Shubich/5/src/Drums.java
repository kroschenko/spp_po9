package org.example;

public class Drums extends MusicalInstrument{
    private  int numberOfPads;

    public Drums(String name, int numberOfPads) {
        super(name);
        this.numberOfPads = numberOfPads;
    }

    public int getNumberOfPads() {
        return numberOfPads;
    }
    @Override
    public String toString() {
        return super.toString() + ", Количество пэдов: " + numberOfPads;
    }
    @Override
    public void tune() {
        System.out.println("Настройка барабана: " + getName());
    }
}
