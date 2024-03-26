public class Tanker extends CargoShip{
    String name;
    Tanker(String name){
        this.name = name;
    }
    public void call(){
        System.out.println("Tanker "+ name + " is here!");
    }
    public void load(Cargo cargo){
        cargo.loadShip();
    }
}
