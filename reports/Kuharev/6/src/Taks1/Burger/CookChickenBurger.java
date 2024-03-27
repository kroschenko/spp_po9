package Burger;

import java.lang.constant.Constable;

public class CookChickenBurger implements CookStrategy {
    @Override
    public int choose(){
        System.out.println("Your choice is 'Chicken burger'\n - Composition: " + Burger.CHICKEN_COMPOSITION + "\n - Price: $" + Burger.CHICKEN_BURGER_COST);
        return Burger.CHICKEN_BURGER_COST;
    }
}
