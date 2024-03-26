import java.text.DecimalFormat;

public class Automobile extends Vehicle{
    int seats, lifting;
    public Automobile(String name, int seats, int lifting) {
        super(name);
        this.seats = seats;
        this.lifting = lifting;
    }
    public void carryPassenger(int passenger_amount, int distance, int ROAD_TYPE){
        System.out.println("Transportation of " + passenger_amount + " passengers over a distance of " + distance + " km with Car '" + name + "'");
        double cost;
        if(passenger_amount > seats){
            System.out.println("Too much passengers");
            return;
        }
        switch (ROAD_TYPE){
            case TYPE_HIGHWAY:
                System.out.println("Road type: highway");
                cost = ((double) distance/100.0 * 8);
                System.out.println("Time: " + decimalFormat.format(((double) distance/120.0)) + " h");
                System.out.println("Total cost: $" + decimalFormat.format(cost));
                System.out.println("Cost per passenger: $" + decimalFormat.format(cost/passenger_amount));
                break;
            case TYPE_RUGGED:
                System.out.println("Road type: rugged terrain");
                if(Math.random()*2 > 1){
                    System.out.println("Car " + name + " stuck on the rugged road\n");
                }else{
                    cost = ((double) distance/100.0 * 14);
                    System.out.println("Time: " + decimalFormat.format((double) distance/40.0) + " h");
                    System.out.println("Total cost: $" + decimalFormat.format(cost));
                    System.out.println("Cost per passenger: $" + decimalFormat.format(cost/passenger_amount));
                }
                break;
            case TYPE_FOREST:
                System.out.println("Road type: forest");
                System.out.println("Car " + name + " stuck in the forest\n");
                break;
            case TYPE_HILLS:
                System.out.println("Road type: hills");
                if(Math.random()*3 > 1) {
                    System.out.println("Car " + name + " stuck on the hill\n");
                }else{
                    cost = ((double) distance/100.0 * 20);
                    System.out.println("Time: " + decimalFormat.format(((double) distance/20.0)) + " h");
                    System.out.println("Total cost: $" + decimalFormat.format(cost));
                    System.out.println("Cost per passenger: $" + decimalFormat.format(cost/passenger_amount));
                }
                break;
            default:
                System.out.println("Type doesn't exist");
                break;
        }
        System.out.println();
    }
    public void carryCargo(int cargo_weight, int distance, int ROAD_TYPE){
        System.out.println("Transportation of cargo weighing " + cargo_weight + " kg over a distance of " + distance + " km with Car '" + name + "'");
        double cost;
        if(cargo_weight > lifting){
            System.out.println("Cargo is too heavy");
            return;
        }
        switch (ROAD_TYPE){
            case TYPE_HIGHWAY:
                System.out.println("Road type: highway");
                cost = ((double) distance/100.0 * 8.0 * (1.0 + (double)cargo_weight/(double)lifting));
                System.out.println("Time: " + decimalFormat.format(((double) distance/120.0)) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            case TYPE_RUGGED:
                System.out.println("Road type: rugged terrain");
                if(Math.random()*2 > 1){
                    System.out.println("Car " + name + " stuck on the rugged road\n");
                }else{
                    cost = ((double) distance/100.0 * 14.0 * (1.0 + (double)cargo_weight/(double)lifting));
                    System.out.println("Time: " + decimalFormat.format((double) distance/40.0) + " h");
                    System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                }
                break;
            case TYPE_FOREST:
                System.out.println("Road type: forest");
                System.out.println("Car " + name + " stuck in the forest\n");
                break;
            case TYPE_HILLS:
                System.out.println("Road type: hills");
                if(Math.random()*3 > 1) {
                    System.out.println("Car " + name + " stuck on the hill\n");
                }else{
                    cost = ((double) distance/100.0 * 20.0 * (1.0 + (double)cargo_weight/(double)lifting));
                    System.out.println("Time: " + decimalFormat.format(((double) distance/20.0)) + " h");
                    System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                }
                break;
            default:
                System.out.println("Type doesn't exist");
                break;
        }
        System.out.println();
    }
}
