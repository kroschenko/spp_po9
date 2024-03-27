import Burger.*;
import Drink.*;
import Pack.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurgerDiner {
    static void MakeOrder(Burger burger, Drink drink, Pack pack){
        System.out.println("Total price: $" + ((double)burger.buy() + drink.selectDrink() + pack.choosePackage()));
    }
    public static Burger[] fillBurgerList(){
        ChickenBurger chickenBurger = new ChickenBurger();
        CheeseBurger cheeseBurger = new CheeseBurger();
        HamBurger hamBurger = new HamBurger();
        VeganBurger veganBurger = new VeganBurger();

        List<Burger> add = Arrays.asList(chickenBurger, cheeseBurger, hamBurger, veganBurger);
        return add.toArray(new Burger[0]);
    }
    public static Drink[] fillColdDrinkList(){
        Pepsi pepsi = new Pepsi();
        CocaCola cocaCola = new CocaCola();
        DrPepper drPepper = new DrPepper();
        Sprite sprite = new Sprite();

        List<Drink> add = Arrays.asList(pepsi, cocaCola, drPepper, sprite);
        return add.toArray(new Drink[0]);
    }
    public static Drink[] fillHotDrinkList(){
        Tea tea = new Tea();
        GreenTea greenTea = new GreenTea();
        Coffee coffee = new Coffee();
        Chocolate chocolate = new Chocolate();

        List<Drink> add = Arrays.asList(tea, greenTea, coffee, chocolate);
        return add.toArray(new Drink[0]);
    }
}
