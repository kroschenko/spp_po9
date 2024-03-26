import java.text.DecimalFormat;

public class Bicycle extends Vehicle{
    public Bicycle(String name) {
        super(name);
    }
    public void carryPassenger(int distance, int ROAD_TYPE){
        System.out.println("Transportation of passenger over a distance of " + distance + " km with Bicycle '" + name + "'");
        double cost;
        switch (ROAD_TYPE){
            case TYPE_HIGHWAY:
                System.out.println("Road type: highway");
                cost = ((double) distance/100.0 * 1);
                System.out.println("Time: " + decimalFormat.format(((double) distance/35.0)) + " h");
                System.out.println("Cost for passenger: $" + decimalFormat.format(cost));
                break;
            case TYPE_RUGGED:
                System.out.println("Road type: rugged terrain");
                cost = ((double) distance/100.0 * 1.5);
                System.out.println("Time: " + decimalFormat.format(((double) distance/20.0)) + " h");
                System.out.println("Cost for passenger: $" + decimalFormat.format(cost));
                break;
            case TYPE_FOREST:
                System.out.println("Road type: forest");
                cost = ((double) distance/100.0 * 1.2);
                System.out.println("Time: " + decimalFormat.format(((double) distance/10.0)) + " h");
                System.out.println("Cost for passenger: $" + decimalFormat.format(cost));
                break;
            case TYPE_HILLS:
                System.out.println("Road type: hills");
                cost = ((double) distance/100.0 * 2.0);
                System.out.println("Time: " + decimalFormat.format(((double) distance/15.0)) + " h");
                System.out.println("Cost for passenger: $" + decimalFormat.format(cost));
                break;
            default:
                System.out.println("Type doesn't exist");
                break;
        }
        System.out.println();
    }
    public void carryCargo(int cargo_weight, int distance, int ROAD_TYPE){
        System.out.println("Transportation of cargo weighing " + cargo_weight + " kg over a distance of " + distance + " km with Bicycle '" + name + "'");
        double cost;
        if(cargo_weight > BICYCLE_LIFTING){
            System.out.println("Cargo is too heavy");
            return;
        }
        switch (ROAD_TYPE){
            case TYPE_HIGHWAY:
                System.out.println("Road type: highway");
                cost = ((double) distance/100.0 * 1.0 * (1.0 + (double)cargo_weight/(double)BICYCLE_LIFTING));
                System.out.println("Time: " + decimalFormat.format(((double) distance/(35.0/(1+(double)cargo_weight/(double)BICYCLE_LIFTING)))) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            case TYPE_RUGGED:
                System.out.println("Road type: rugged terrain");
                cost = ((double) distance/100.0 * 1.5 * (1.0 + (double)cargo_weight/(double)BICYCLE_LIFTING));
                System.out.println("Time: " + decimalFormat.format(((double) distance/(20.0/(1+(double)cargo_weight/(double)BICYCLE_LIFTING)))) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            case TYPE_FOREST:
                System.out.println("Road type: forest");
                cost = ((double) distance/100.0 * 1.2 * (1.0 + (double)cargo_weight/(double)BICYCLE_LIFTING));
                System.out.println("Time: " + decimalFormat.format(((double) distance/(10.0/(1+(double)cargo_weight/(double)BICYCLE_LIFTING)))) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            case TYPE_HILLS:
                System.out.println("Road type: hills");
                cost = ((double) distance/100.0 * 2.0 * (1.0 + (double)cargo_weight/(double)BICYCLE_LIFTING));
                System.out.println("Time: " + decimalFormat.format(((double) distance/(15.0/(1+(double)cargo_weight/(double)BICYCLE_LIFTING)))) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            default:
                System.out.println("Type doesn't exist");
                break;
        }
        System.out.println();
    }
}
