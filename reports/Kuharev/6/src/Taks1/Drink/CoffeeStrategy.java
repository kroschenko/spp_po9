package Drink;

public class CoffeeStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Hot.COFFEE + "\n - Price: $" + Hot.COFFEE_PRICE);
        return Hot.COFFEE_PRICE;
    }
}
