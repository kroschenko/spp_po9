package Drink;

public class GreenTeaStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Hot.GREEN_TEA + "\n - Price: $" + Hot.GREENTEA_PRICE);
        return Hot.GREENTEA_PRICE;
    }
}
