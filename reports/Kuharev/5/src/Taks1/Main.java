import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ship> ship_park = new ArrayList<Ship>();
        ship_park.add(new Tanker("Hispaniola"));
        ship_park.add(new Tanker("Admiral Benbow"));
        for(Ship ship : ship_park){
            manageShip(ship);
        }
    }
    public static void manageShip(Ship ship){
        Cargo cargo = new Cargo();
        ship.call();
        ship.load(cargo);
        ship.transportTo("Kidd's Island");
        ship.goToStorage();
        System.out.println();
    }
}