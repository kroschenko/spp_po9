package Burger;

public class CookHamBurger implements CookStrategy {
    @Override
    public int choose(){
        System.out.println("Your choice is 'Hamburger'\n - Composition: " + Burger.HAM_COMPOSITION + "\n - Price: $" + Burger.HAMBURGER_COST);
        return Burger.HAMBURGER_COST;
    }
}
