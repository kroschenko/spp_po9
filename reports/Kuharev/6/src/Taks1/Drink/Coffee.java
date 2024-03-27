package Drink;

public class Coffee extends Hot{
    public Coffee(){
        this.name = Hot.COFFEE;
        this.drinkStrategy = new CoffeeStrategy();
    }
    public void showInfo(){
        show(name, Hot.COFFEE_PRICE);
    }
}
