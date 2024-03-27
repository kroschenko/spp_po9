public class Percussion_Instrument extends Instrument{
    Percussion_Instrument(int cost,int year, String brand) throws Exception {
        super( cost, year, brand);
        this.type=new String("Percussion");
    }
    public void boom(){
        new PlayMp3("./barabannaya-drob-otlichnaya-shutka.mp3");
    }
}
