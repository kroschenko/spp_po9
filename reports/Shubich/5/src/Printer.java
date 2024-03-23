package org.example;

public abstract class Printer implements PrintDevice {
    private String model;

    public Printer(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void print(String text) {
        System.out.println("Печать на принтере " + model + ": " + text );
    }

    // дополнительные абстрактные методы для реализации в подклассе

    public abstract void on();
    public abstract void off();
}
