package Drink;

public class GreenTea extends Hot{
    public GreenTea(){
        this.name = Hot.GREEN_TEA;
        this.drinkStrategy = new GreenTeaStrategy();
    }
    public void showInfo(){
        show(name, Hot.GREENTEA_PRICE);
    }
}
