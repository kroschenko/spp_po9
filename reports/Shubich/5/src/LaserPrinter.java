package org.example;

public class LaserPrinter  extends Printer{

    public LaserPrinter(String model) {
        super(model);
    }

    @Override
    public void on() {
        System.out.println("Подключение лазерного принтера " + getModel());
    }

    @Override
    public void off() {
        System.out.println("Отключение лазерного принтера " + getModel());
    }
}
