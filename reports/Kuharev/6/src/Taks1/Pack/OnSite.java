package Pack;

public class OnSite extends Pack {
    public OnSite(){
        this.name = Pack.ON_SITE;
        this.packageStrategy = new OnSiteStrategy();
    }
}
