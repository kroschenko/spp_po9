public class String_Instrument extends Instrument{
    String_Instrument(int cost, int year, String brand) throws Exception {
        super(cost, year, brand);
        this.type = new String("String");
    }
    public void trun(){
        new PlayMp3("./jg-032316-sfx-acoustic-guitar-a-minor-chord.mp3");
    }
}
