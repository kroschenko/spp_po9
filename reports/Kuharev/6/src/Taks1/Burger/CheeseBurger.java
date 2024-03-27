package Burger;

import Burger.Burger;

public class CheeseBurger extends Burger {
    public CheeseBurger(){
        this.name = "Cheeseburger";
        this.cookStrategy = new CookCheeseBurger();
    }
    public void showInfo(){
        show(name, Burger.CHEESE_COMPOSITION, Burger.CHEESEBURGER_COST);
    }
}
