package Drink;

public class CocaCola extends Cold{
    public CocaCola(){
        this.name = Cold.COLA;
        this.drinkStrategy = new CocaColaStrategy();
    }
    public void showInfo(){
        show(name, Cold.COLA_PRICE);
    }
}
