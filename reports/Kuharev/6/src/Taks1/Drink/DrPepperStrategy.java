package Drink;

public class DrPepperStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Cold.DRPEPPER + "\n - Price: $" + Cold.DRPEPPER_PRICE);
        return Cold.DRPEPPER_PRICE;
    }
}
