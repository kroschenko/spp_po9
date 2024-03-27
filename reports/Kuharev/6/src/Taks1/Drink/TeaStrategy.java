package Drink;

public class TeaStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Hot.TEA + "\n - Price: $" + Hot.TEA_PRICE);
        return Hot.TEA_PRICE;
    }
}
