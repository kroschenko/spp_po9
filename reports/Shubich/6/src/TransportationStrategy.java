package org.example;

// конкретная стратегия для проезда
public class TransportationStrategy implements TourPackageStrategy{

    @Override
    public int calculateCost() {
        return 100;
    }
}
