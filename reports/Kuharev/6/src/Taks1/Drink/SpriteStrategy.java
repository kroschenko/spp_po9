package Drink;

public class SpriteStrategy implements DrinkStrategy{
    public double select(){
        System.out.println("Selected drink: " + Cold.SPRITE + "\n - Price: $" + Cold.SPRITE_PRICE);
        return Cold.SPRITE_PRICE;
    }
}
