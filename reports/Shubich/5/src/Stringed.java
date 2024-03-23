package org.example;

public class Stringed  extends MusicalInstrument{
    private int numberOfStringe;

    public Stringed(String name, int numberOfStringe) {
        super(name);
        this.numberOfStringe = numberOfStringe;
    }

    public int getNumberOfStringe() {
        return numberOfStringe;
    }

    @Override
    public void tune() {
        System.out.println("Настройка струнного инструмента: " + getName());

    }
    @Override
    public String toString() {
        return super.toString() + ", Количество струн: " + numberOfStringe;
    }
}
