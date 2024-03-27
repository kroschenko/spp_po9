package Burger;

public class HamBurger extends Burger {
    public HamBurger(){
        this.name = "Hamburger";
        this.cookStrategy = new CookHamBurger();
    }
    public void showInfo(){
        show(name, Burger.HAM_COMPOSITION, Burger.HAMBURGER_COST);
    }
}
