package Burger;

import Burger.Burger;

public class VeganBurger extends Burger {
    public VeganBurger(){
        this.name = "Vegan burger";
        this.cookStrategy = new CookVeganBurger();
    }
    public void showInfo(){
        show(name, Burger.VEGAN_COMPOSITION, Burger.VEGAN_BURGER_COST);
    }
}
