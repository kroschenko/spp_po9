package Drink;

public abstract class Drink {
    protected String name;
    DrinkStrategy drinkStrategy;
    public double selectDrink(){
        return drinkStrategy.select();
    }
    public abstract void showInfo();
    protected static void show(String name, double price){
        System.out.println(name + "\n\t - Price: $" + price);
    }
}
