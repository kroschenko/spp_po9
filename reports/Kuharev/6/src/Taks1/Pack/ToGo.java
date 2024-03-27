package Pack;

public class ToGo extends Pack {
    public ToGo(){
        this.name = Pack.TO_GO;
        this.packageStrategy = new ToGoStrategy();
    }
}
