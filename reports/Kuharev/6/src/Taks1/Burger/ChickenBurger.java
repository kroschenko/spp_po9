package Burger;

import Burger.Burger;

public class ChickenBurger extends Burger {
    public ChickenBurger(){
        this.name = "Chicken burger";
        this.cookStrategy = new CookChickenBurger();
    }
    public void showInfo(){
        show(name, Burger.CHICKEN_COMPOSITION, Burger.CHICKEN_BURGER_COST);
    }
}
