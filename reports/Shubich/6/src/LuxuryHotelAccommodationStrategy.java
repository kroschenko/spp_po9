package org.example;

public class LuxuryHotelAccommodationStrategy implements TourPackageStrategy {
        @Override
        public int calculateCost() {
            return 300;  // Пример стоимости проживания в отеле высокого класса
        }
}
