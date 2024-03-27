package Drink;

public class Sprite extends Cold{
    public Sprite(){
        this.name = Cold.SPRITE;
        this.drinkStrategy = new SpriteStrategy();
    }
    public void showInfo(){
        show(name, Cold.SPRITE_PRICE);
    }
}
