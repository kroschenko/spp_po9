package org.example;

// конкретная стратегия для проживания

public class AccommodationStrategy implements TourPackageStrategy{
    @Override
    public int calculateCost() {
        return 200;
    }
}
