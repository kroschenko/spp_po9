package Pack;

public class OnSiteStrategy implements PackageStrategy{
    public double select(){
        System.out.println("Selected package type: " + Pack.ON_SITE);
        return Pack.ONSITE_COST;
    }
}
