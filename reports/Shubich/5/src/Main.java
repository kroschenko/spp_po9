package org.example;

public class Main {
    public static void main(String[] args) {
        // task1
        LaserPrinter laserPrinter = new LaserPrinter("Samsung S90");
        laserPrinter.on();
        laserPrinter.print("Лабораторная работа №5, задание 1, выполнила Шубич Дарья Константиновна.");
        laserPrinter.off();

        System.out.println();

        //task2
        Orchestra orchestra = new Orchestra();
        MusicalInstrument[] instruments = new MusicalInstrument[5];

        instruments[0] = new Drums("Electric Drums 432", 5);
        instruments[1] = new Stringed("Bas Guitar Fender 400", 4);
        instruments[2] = new Stringed("Acoustic Guitar Fender 212", 6);
        instruments[3] = new Wind("Flute 'Flora'", "Дуб");
        instruments[4] = new Wind("Saxophone 'JazzyVibes'", "Латунь");
        for (MusicalInstrument instrument : instruments) {
            System.out.println(instrument.toString());
            instrument.tune();
            System.out.println();
        }
        for (MusicalInstrument instrument : instruments) {
            orchestra.addInstrument(instrument);
        }
        System.out.println("Оркестр:");
        orchestra.printOrchestra();


    }
}