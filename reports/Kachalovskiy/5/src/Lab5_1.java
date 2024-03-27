package Lab5_1;

public class Lab5_1 {

    public static void main(String[] args) {
        AircraftCarrier carrier = new AircraftCarrier("Корабль", 90);

        carrier.move(10, 20);
        Destroyer enemy = new Destroyer("Враг");
        carrier.attack(enemy);

        System.out.println("Имя: " + carrier.getName());
        System.out.println("Тип: " + carrier.getType());
        System.out.println("Количество авианосцев: " + carrier.getNumberOfAircraft());

    }
}
