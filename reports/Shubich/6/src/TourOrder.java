package org.example;

public class TourOrder {
    private TourPackageStrategy strategy;

    public TourOrder(TourPackageStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TourPackageStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateTotalCost() {
        return this.strategy.calculateCost();
    }
}
