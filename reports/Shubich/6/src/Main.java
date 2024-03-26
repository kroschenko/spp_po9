package org.example;

public class Main {
    public static void main(String[] args) {
        TourPackageStrategy transportationStrategy = new TransportationStrategy();
        TourPackageStrategy accommodationStrategy = new AccommodationStrategy();
        TourPackageStrategy luxuryAccommodationStrategy = new LuxuryHotelAccommodationStrategy();
        TourPackageStrategy firstClassTransportation = new FirstClassTrainTransportationStrategy();

        TourOrder tourOrder = new TourOrder(transportationStrategy);

        int totalCost = tourOrder.calculateTotalCost();
        System.out.println("Total cost of the tour order(only cheap transport): $" + totalCost);

        tourOrder.setStrategy(accommodationStrategy);

        totalCost += tourOrder.calculateTotalCost();
        System.out.println("Total cost of the tour order(cheap transport + cheap hotel): $" + totalCost);

        tourOrder.setStrategy(firstClassTransportation);

        totalCost = tourOrder.calculateTotalCost();
        System.out.println("Total cost of the tour order(only luxury transport): $" + totalCost);

        tourOrder.setStrategy(luxuryAccommodationStrategy);

        totalCost += tourOrder.calculateTotalCost();
        System.out.println("Total cost of the tour order(luxury transport + luxury hotel): $" + totalCost);

        System.out.println();

        // task 2
        File file1 = new File("example1", 1024, "txt", "2024-02-07");
        File file2 = new File("example2", 2048, "jpg", "2024-01-09");

        Directory directory = new Directory("MyFiles");
        directory.addChild(file1);
        directory.addChild(file2);

        directory.showInfo();
        directory.removeChild(file1);
        directory.showInfo();

        // task 3
        System.out.println();
        DirectoryThird root = new DirectoryThird("Root");

        File file3 = new File("example3", 2048, "png", "2024-10-12");
        File file4 = new File("example4", 2048, "docx", "2024-11-01");


        DirectoryThird dir1 = new DirectoryThird("Dir1");
        File file5 = new File("example5", 2048, "xml", "2024-12-08");
        dir1.add(file5);


        DirectoryThird dir2 = new DirectoryThird("Dir2");
        File file6 = new File("example6", 2048, "jpeg", "2024-07-02");
        dir2.add(file6);

        root.add(file3);
        root.add(file4);
        root.add(dir1);
        root.add(dir2);

        root.showInfo();
    }
}