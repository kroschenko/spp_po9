package Burger;

public class CookCheeseBurger implements CookStrategy {
    @Override
    public int choose(){
        System.out.println("Your choice is 'Cheeseburger'\n - Composition: " + Burger.CHEESE_COMPOSITION + "\n - Price: $" + Burger.CHEESEBURGER_COST);
        return Burger.CHEESEBURGER_COST;
    }
}
