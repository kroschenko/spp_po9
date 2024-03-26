public abstract class CargoShip implements Ship{
    public abstract void call();
    public abstract void load(Cargo cargo);
    public void transportTo(String destination){
        System.out.println("Cargo ship has arrived to the " + destination);
    }
    public void goToStorage(){
        System.out.println("Cargo ship was returned to the storage");
    }
}
