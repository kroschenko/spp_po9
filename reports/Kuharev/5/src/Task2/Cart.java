public class Cart extends Vehicle{
    int seats, lifting;
    public Cart(String name, int seats, int lifting) {
        super(name);
        this.seats = seats;
        this.lifting = lifting;
    }
    public void carryPassenger(int passenger_amount, int distance, int ROAD_TYPE){
        System.out.println("Transportation of " + passenger_amount + " passengers over a distance of " + distance + " km with Cart '" + name + "'");
        double cost;
        if(passenger_amount > seats){
            System.out.println("Too much passengers");
            return;
        }
        switch (ROAD_TYPE){
            case TYPE_HIGHWAY:
                System.out.println("Road type: highway");
                cost = ((double) distance/100.0 * 2.0);
                System.out.println("Time: " + decimalFormat.format(((double) distance/60.0)) + " h");
                System.out.println("Total cost: $" + decimalFormat.format(cost));
                System.out.println("Cost per passenger: $" + decimalFormat.format(cost/passenger_amount));
                break;
            case TYPE_RUGGED:
                System.out.println("Road type: rugged terrain");
                cost = ((double) distance/100.0 * 3.0);
                System.out.println("Time: " + decimalFormat.format(((double) distance/35.0)) + " h");
                System.out.println("Total cost: $" + decimalFormat.format(cost));
                System.out.println("Cost per passenger: $" + decimalFormat.format(cost/passenger_amount));
                break;
            case TYPE_FOREST:
                System.out.println("Road type: forest");
                cost = ((double) distance/100.0 * 2.5);
                System.out.println("Time: " + decimalFormat.format(((double) distance/20.0)) + " h");
                System.out.println("Total cost: $" + decimalFormat.format(cost));
                System.out.println("Cost per passenger: $" + decimalFormat.format(cost/passenger_amount));
                break;
            case TYPE_HILLS:
                System.out.println("Road type: hills");
                cost = ((double) distance/100.0 * 3.5);
                System.out.println("Time: " + decimalFormat.format(((double) distance/15.0)) + " h");
                System.out.println("Total cost: $" + decimalFormat.format(cost));
                System.out.println("Cost per passenger: $" + decimalFormat.format(cost/passenger_amount));
                break;
            default:
                System.out.println("Type doesn't exist");
                break;
        }
        System.out.println();
    }
    public void carryCargo(int cargo_weight, int distance, int ROAD_TYPE){
        System.out.println("Transportation of cargo weighing " + cargo_weight + " kg over a distance of " + distance + " km with Cart '" + name + "'");
        double cost;
        if(cargo_weight > lifting){
            System.out.println("Cargo is too heavy");
            return;
        }
        switch (ROAD_TYPE){
            case TYPE_HIGHWAY:
                System.out.println("Road type: highway");
                cost = ((double) distance/100.0 * 2.5 * (1.0 + (double)cargo_weight/(double)lifting));
                System.out.println("Time: " + decimalFormat.format(((double) distance/60.0)) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            case TYPE_RUGGED:
                System.out.println("Road type: rugged terrain");
                cost = ((double) distance/100.0 * 3.5 * (1.0 + (double)cargo_weight/(double)lifting));
                System.out.println("Time: " + decimalFormat.format(((double) distance/35.0)) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            case TYPE_FOREST:
                System.out.println("Road type: forest");
                cost = ((double) distance/100.0 * 3.0 * (1.0 + (double)cargo_weight/(double)lifting));
                System.out.println("Time: " + decimalFormat.format(((double) distance/20.0)) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            case TYPE_HILLS:
                System.out.println("Road type: hills");
                cost = ((double) distance/100.0 * 4.0 * (1.0 + (double)cargo_weight/(double)lifting));
                System.out.println("Time: " + decimalFormat.format(((double) distance/15.0)) + " h");
                System.out.println("Transportation cost: $" + decimalFormat.format(cost));
                break;
            default:
                System.out.println("Type doesn't exist");
                break;
        }
        System.out.println();
    }
}
