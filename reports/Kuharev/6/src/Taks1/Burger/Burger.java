package Burger;

public abstract class Burger {
    final public static int VEGAN_BURGER_COST = 6;
    final public static int HAMBURGER_COST = 8;
    final public static int CHEESEBURGER_COST = 10;
    final public static int CHICKEN_BURGER_COST = 9;
    final public static String VEGAN_COMPOSITION = "Bun, soy cutlet, tofu, onion, tomatoes, lettuce leaves, soy based sauce";
    final public static String CHICKEN_COMPOSITION = "Bun, fried chicken fillet, onion, lettuce leaves, special sauce";
    final public static String CHEESE_COMPOSITION = "Bun, cutlet, cheese, onion, lettuce leaves, special sauce";
    final public static String HAM_COMPOSITION = "Bun, ham slice, marinated onion, lettuce leaves, special sauce";
    CookStrategy cookStrategy;
    String name;
    public int buy(){
        return cookStrategy.choose();
    }
    public abstract void showInfo();
    protected static void show(String name, String composition, int price){
        System.out.println(name + "\n\t - Composition: " + composition + "\n\t - Price: $" + price);
    }
}
