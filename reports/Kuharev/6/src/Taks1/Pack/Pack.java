package Pack;

public class Pack {
    protected String name;
    PackageStrategy packageStrategy;
    final public static String TO_GO = "to go";
    final public static String ON_SITE = "on site";
    final public static double TOGO_COST = 0.5;
    final public static double ONSITE_COST = 0.2;

    public String getName(){
        return name;
    }
    public double choosePackage(){
        return packageStrategy.select();
    }
}
