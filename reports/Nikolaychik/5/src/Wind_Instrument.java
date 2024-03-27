public class Wind_Instrument extends Instrument{
    Wind_Instrument(int cost, int year, String brand) throws Exception {
        super(cost, year, brand);
        this.type = new String("Wind");
    }
    public void dzyn(){
        new PlayMp3("./musicbossorg_Shitty_flute_-_Harry_Potter_Theme_64368916.mp3");
    }
}