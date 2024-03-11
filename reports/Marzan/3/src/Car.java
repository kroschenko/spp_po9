import java.util.ArrayList;
import java.util.List;

enum Color
{
    YELLOW,
    RED,
    GREEN,
    BLUE,
    PURPLE,
    WHITE,
    METALLIC
}
public class Car
{
    int id;
    String mark;
    String model;
    int yearOfRelease;
    Color color;
    int price;
    String registrationNumber;
    int carNumber;
    String fullNameOfPersonWhoRentedIt = "NoName";
    String passportNumberOfTenant = "NoPassport";
    public Car(int id, String mark, String model, int yearOfRelease,
               Color color, int price, String registrationNumber,
               int carNumber)
    {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.yearOfRelease = yearOfRelease;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
        this.carNumber = carNumber;
    }
    public Car(int id, String mark, String model, int yearOfRelease,
               Color color, int price, String registrationNumber,
               int carNumber, String fullNameOfPersonWhoRentedIt,
               String passportNumberOfTenant)
    {
        this(id, mark, model, yearOfRelease, color, price, registrationNumber,
                carNumber);
        this.fullNameOfPersonWhoRentedIt = fullNameOfPersonWhoRentedIt;
        this.passportNumberOfTenant = passportNumberOfTenant;

    }

    @Override
    public String toString()
    {
        return "Id: " + id + " Mark: " + mark + " Model: " + model + " Year of release: " + yearOfRelease
                + " Color: " + color + " Price: " + price + " Registration number: " + registrationNumber
                + " Car number: " + carNumber + " Name of person who rented it: " + fullNameOfPersonWhoRentedIt
                + " Passport number of tenant:" + passportNumberOfTenant;
    }
}

class CarRentalSystem
{
    private List<Car> cars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getCarsByBrand(String mark) {
        List<Car> carsByMark = new ArrayList<>();
        for (Car car : cars) {
            if (car.mark.equalsIgnoreCase(mark)) {
                carsByMark.add(car);
            }
        }
        return carsByMark;
    }

    public List<Car> getCarsByModelAndYears(String model, int years)
    {
        List<Car> carsByModelAndYears = new ArrayList<>();
        int currentYear = java.time.Year.now().getValue();
        for (Car car : cars)
        {
            if (car.model.equalsIgnoreCase(model) && (currentYear - car.yearOfRelease) > years)
            {
                carsByModelAndYears.add(car);
            }
        }
        return carsByModelAndYears;
    }

    public List<Car> getCarsByYearAndPrice(int year, int price) {
        List<Car> carsByYearAndPrice = new ArrayList<>();
        for (Car car : cars) {
            if (car.yearOfRelease == year && car.price > price) {
                carsByYearAndPrice.add(car);
            }
        }
        return carsByYearAndPrice;
    }

    public List<Car> getRentedCars() {
        List<Car> rentedCars = new ArrayList<>();
        for (Car car : cars) {
            if (!car.fullNameOfPersonWhoRentedIt.equalsIgnoreCase("NoName")) {
                rentedCars.add(car);
            }
        }
        return rentedCars;
    }

    public List<Car> getRentedCarsWithTenantsInfo() {
        List<Car> rentedCarsWithTenantsInfo = new ArrayList<>();
        for (Car car : cars) {
            if (!car.fullNameOfPersonWhoRentedIt.equalsIgnoreCase("NoName")) {
                rentedCarsWithTenantsInfo.add(car);
            }
        }
        return rentedCarsWithTenantsInfo;
    }
}