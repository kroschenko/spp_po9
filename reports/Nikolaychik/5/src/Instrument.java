public class Instrument {
    protected int cost;
    protected int year;
    protected String brand;
    protected String type;
    Instrument(int cost,int year, String brand) throws Exception {
        this.cost=cost;
        this.year=year;
        this.brand=brand;
        type=null;
    }
    public void out(){
        System.out.println("cost: " + cost);
        System.out.println("year: " +year);
        System.out.println("brand: " +brand);
        if(type!=null)
            System.out.println("type: " +type);
        System.out.println();
        System.out.println();
    }
}
