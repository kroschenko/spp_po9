import java.text.DecimalFormat;

public class Vehicle {
    final public static int TYPE_HIGHWAY = 1;
    final public static int TYPE_RUGGED = 2;
    final public static int TYPE_FOREST = 3;
    final public static int TYPE_HILLS = 4;
    final public static int BICYCLE_SEATS = 1;
    final public static int BICYCLE_LIFTING = 20;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    String name;
    Vehicle(String name){
        this.name = name;
    }

}
