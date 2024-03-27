package Drink;

public class Tea extends Hot{
    public Tea(){
        this.name = Hot.TEA;
        this.drinkStrategy = new TeaStrategy();
    }
    public void showInfo(){
        show(name, Hot.TEA_PRICE);
    }
}
