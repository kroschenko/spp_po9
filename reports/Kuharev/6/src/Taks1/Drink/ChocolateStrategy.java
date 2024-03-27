package Drink;

public class ChocolateStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Hot.CHOCOLATE + "\n - Price: $" + Hot.CHOCOLATE_PRICE);
        return Hot.CHOCOLATE_PRICE;
    }
}
