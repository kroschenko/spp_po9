package Drink;

public class CocaColaStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Cold.COLA + "\n - Price: $" + Cold.COLA_PRICE);
        return Cold.COLA_PRICE;
    }
}
