package Drink;

public class Chocolate extends Hot{
    public Chocolate(){
        this.name = Hot.CHOCOLATE;
        this.drinkStrategy = new ChocolateStrategy();
    }
    public void showInfo(){
        show(name, Hot.CHOCOLATE_PRICE);
    }
}
