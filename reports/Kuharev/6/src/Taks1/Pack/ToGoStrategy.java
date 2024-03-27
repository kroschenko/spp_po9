package Pack;

public class ToGoStrategy implements PackageStrategy{
    public double select(){
        System.out.println("Selected package type: " + Pack.TO_GO);
        return Pack.TOGO_COST;
    }
}
