public class Main {
    public static void main(String[] args) {
        Wheel normal_wheel1 = new Wheel("Michelin", 16, "passenger", 2.1, 100);
        Wheel normal_wheel2 = new Wheel("Michelin", 16, "passenger", 2.1, 100);
        Wheel invalid_wheel = new Wheel("Michelin", 10, "passenger", 2.1, 100);
        Wheel weak_wheel = new Wheel("Michelin", 15, "until", 2.1, 10);
        Wheel lower_wheel = new Wheel("Michelin", 16, "passenger", 1.001, 100);
        Automobile car1 = null;
        Automobile car2 = null;

        try{
            car1 = new Automobile("McLaren", normal_wheel1, normal_wheel2, invalid_wheel, lower_wheel);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        try{
            car2 = new Automobile("Нива", normal_wheel1, normal_wheel2, weak_wheel, lower_wheel);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        if(car2 != null){
            car2.drive(2000);
            car2.maintenance();
            car2.drive(100);
            car2.maintenance();
            car2.drive(20000);
            car2.maintenance();
            car2.OverPump(2);
            car2.OverPump(2);
            car2.OverPump(2);
        }
    }
}