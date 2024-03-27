package Burger;

public class CookVeganBurger implements CookStrategy {
    @Override
    public int choose(){
        System.out.println("Your choice is 'Vegetarian burger'\n - Composition: " + Burger.VEGAN_COMPOSITION + "\n - Price: $" + Burger.VEGAN_BURGER_COST);
        return Burger.VEGAN_BURGER_COST;
    }
}
