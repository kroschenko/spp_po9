package Drink;

public class Pepsi extends Cold{
    public Pepsi(){
        this.name = Cold.PEPSI;
        this.drinkStrategy = new PepsiStrategy();
    }
    public void showInfo(){
        show(name, Cold.PEPSI_PRICE);
    }
}
