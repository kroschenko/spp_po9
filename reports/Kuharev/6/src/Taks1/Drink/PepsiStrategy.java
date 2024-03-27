package Drink;

public class PepsiStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Cold.PEPSI + "\n - Price: $" + Cold.PEPSI_PRICE);
        return Cold.PEPSI_PRICE;
    }
}
