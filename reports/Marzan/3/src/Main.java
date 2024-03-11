import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("Task 1:");
        EquilateralTriangle triangle1 = new EquilateralTriangle(5.0);
        EquilateralTriangle triangle2 = new EquilateralTriangle(7.5);

        System.out.println("Triangle 1: " + triangle1);
        System.out.println("Perimeter of Triangle 1: " + triangle1.calculatePerimeter());
        System.out.println("Area of Triangle 1: " + triangle1.calculateArea());
        System.out.println("Is Triangle 1 valid? " + triangle1.isTriangleValid());

        System.out.println();

        System.out.println("Triangle 2: " + triangle2);
        System.out.println("Perimeter of Triangle 2: " + triangle2.calculatePerimeter());
        System.out.println("Area of Triangle 2: " + triangle2.calculateArea());
        System.out.println("Is Triangle 2 valid? " + triangle2.isTriangleValid());

        System.out.println();

        System.out.println("Are Triangle 1 and Triangle 2 equal? " + triangle1.equals(triangle2));


        System.out.println();
        System.out.println("Task 2:");

        CarRentalSystem rentalSystem = new CarRentalSystem();

        rentalSystem.addCar(new Car(1, "Toyota", "Corolla", 2018, Color.RED, 20000,
                "AB12345", 123));
        rentalSystem.addCar(new Car(2, "BMW", "X5", 2020, Color.BLUE, 50000,
                "CD67890", 456, "John Doe",
                "1234567890"));
        rentalSystem.addCar(new Car(3, "Mercedes", "E-Class", 2019, Color.WHITE, 35000,
                "EF24680", 789));

        List<Car> allCars = rentalSystem.getCars();
        System.out.println("All Cars:");
        for (Car car : allCars)
        {
            System.out.println(car);
        }

        List<Car> toyotaCars = rentalSystem.getCarsByBrand("Toyota");
        System.out.println("\nToyota Cars:");
        for (Car car : toyotaCars)
        {
            System.out.println(car);
        }

        List<Car> oldCars = rentalSystem.getCarsByModelAndYears("Corolla", 3);
        System.out.println("\nOld Toyota Corolla Cars (>3 years):");
        for (Car car : oldCars)
        {
            System.out.println(car);
        }

        List<Car> expensiveCars = rentalSystem.getCarsByYearAndPrice(2019, 30000);
        System.out.println("\nExpensive 2019 Cars (>30000):");
        for (Car car : expensiveCars)
        {
            System.out.println(car);
        }

        List<Car> rentedCars = rentalSystem.getRentedCars();
        System.out.println("\nRented Cars:");
        for (Car car : rentedCars)
        {
            System.out.println(car);
        }

        List<Car> rentedCarsWithTenantsInfo = rentalSystem.getRentedCarsWithTenantsInfo();
        System.out.println("\nRented Cars with Tenants Info:");
        for (Car car : rentedCarsWithTenantsInfo)
        {
            System.out.println(car);
        }
    }
}