public class Main {
    public static void main(String[] args) {
        Automobile car = new Automobile("McLaren", 4, 100);
        car.carryPassenger(3, 100, Vehicle.TYPE_HIGHWAY);
        car.carryCargo(10, 100, Vehicle.TYPE_HIGHWAY);
        Bicycle bicycle = new Bicycle("Aist");
        bicycle.carryCargo(20, 100, Vehicle.TYPE_HIGHWAY);
        bicycle.carryPassenger(100, Vehicle.TYPE_HIGHWAY);
        Cart cart = new Cart("Povozka", 5, 100);
        cart.carryPassenger(3, 100, Vehicle.TYPE_FOREST);
        cart.carryCargo(50, 100, Vehicle.TYPE_FOREST);
    }
}