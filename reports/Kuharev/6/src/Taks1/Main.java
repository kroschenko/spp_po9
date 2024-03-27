import Burger.*;
import Drink.*;
import Pack.*;

import java.util.Scanner;

public class Main {
    public static Burger[] burgers;
    public static Drink[] coldDrinks;
    public static Drink[] hotDrinks;
    public static void main(String[] args) {
        burgers = BurgerDiner.fillBurgerList();
        coldDrinks = BurgerDiner.fillColdDrinkList();
        hotDrinks = BurgerDiner.fillHotDrinkList();
        Scanner read = new Scanner(System.in);

        while (true){
            showBurgerList();

            formOrder();
            System.out.print("\nMake another order? (N/y):");
            try {
                if(!read.next().toLowerCase().equals("y")){
                    return;
                }
            }catch (Exception e){
                System.out.println("Wrong action!");
            }
        }
    }
    public static void formOrder(){
        Drink[] drinks;
        Scanner read = new Scanner(System.in);
        String action;
        Burger burger;
        Drink drink;
        Pack pack = null;
        System.out.print("Select burger number: ");
        action = read.next();

        int action_num = 0;
        try{
            action_num = Integer.parseInt(action)-1;
        }catch(Exception ex){
            System.out.println("Please enter correct number");
            return;
        }
        if(action_num >= burgers.length){
            System.out.println("There's no " + action + "th burger");
            return;
        }else{
            burger = burgers[action_num];
        }

        System.out.println("Do you want to order hot drink? (N/y)");
        action = read.next();
        if(action.toLowerCase().equals("y")){
            drinks = hotDrinks;
            showHotDrinkList();
        }else{
            drinks = coldDrinks;
            showColdDrinkList();
        }

        System.out.print("Select drink number: ");
        action = read.next();
        try{
            action_num = Integer.parseInt(action)-1;
        }catch(Exception ex){
            System.out.println("Please enter correct number");
            return;
        }
        if(action_num >= drinks.length){
            System.out.println("There's no " + action + "th drink");
            return;
        }else{
            drink = drinks[action_num];
        }
        System.out.println("Would you like to take your order with you? (N/y)");
        action = read.next();
        if(action.toLowerCase().equals("y")){
            pack = new ToGo();
        }else{
            pack = new OnSite();
        }
        BurgerDiner.MakeOrder(burger, drink, pack);
    }
    public static void showBurgerList(){
        System.out.println("Burgers list:");
        for(int i = 0; i < burgers.length; ++i){
            System.out.print("  " + (i+1) + ". ");
            burgers[i].showInfo();
        }
        System.out.println();
    }
    public static void showColdDrinkList(){
        System.out.println("Cold drinks list:");
        for(int i = 0; i < coldDrinks.length; ++i){
            System.out.print("  " + (i+1) + ". ");
            coldDrinks[i].showInfo();
        }
        System.out.println();
    }
    public static void showHotDrinkList(){
        System.out.println("Hot drinks list:");
        for(int i = 0; i < hotDrinks.length; ++i){
            System.out.print("  " + (i+1) + ". ");
            hotDrinks[i].showInfo();
        }
        System.out.println();
    }
}