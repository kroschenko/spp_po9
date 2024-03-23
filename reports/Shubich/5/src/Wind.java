package org.example;

public class Wind extends MusicalInstrument{
    private String material;

    public Wind(String name, String material) {
        super(name);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
    @Override
    public String toString() {
        return super.toString() + ", Материал: " + material;
    }
    @Override
    public void tune() {
        System.out.println("Настройка духового инструмента: " + getName());

    }
}
