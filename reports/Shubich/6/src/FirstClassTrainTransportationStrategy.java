package org.example;

public class FirstClassTrainTransportationStrategy implements TourPackageStrategy{
    @Override
    public int calculateCost() {
        return 150;  // Пример стоимости транспорта первого класса
    }
}
