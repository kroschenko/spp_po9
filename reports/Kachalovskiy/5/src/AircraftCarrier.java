package Lab5_1;

public class AircraftCarrier extends WarShip {

    private int numberOfAircraft;

    public AircraftCarrier(String name, int numberOfAircraft) {
        super(name, "Aircraft Carrier");
        this.numberOfAircraft = numberOfAircraft;
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Авианосец " + getName() + " перемещается в (" + x + "," + y + ")");
    }

    @Override
    public void attack(Ship target) {
        System.out.println("Авианосец " + getName() + " атакует " + target.getName());
    }

    public int getNumberOfAircraft() {
        return numberOfAircraft;
    }

}
