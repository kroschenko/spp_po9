package Drink;

public class DrPepper extends Cold{
    public DrPepper(){
        this.name = Cold.DRPEPPER;
        this.drinkStrategy = new DrPepperStrategy();
    }
    public void showInfo(){
        show(name, Cold.DRPEPPER_PRICE);
    }
}
