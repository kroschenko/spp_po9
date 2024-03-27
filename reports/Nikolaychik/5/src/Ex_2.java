public class Ex_2 {
    Ex_2() throws Exception {
        Instrument[] Orchestra = new Instrument[4];
        try {
            Percussion_Instrument per = new Percussion_Instrument(200,2000,"Boomba");
            per.boom();
            Orchestra[0] =per;
            Orchestra[0].out();

            String_Instrument ser = new String_Instrument(3200,2020,"Strings");
            ser.trun();
            Orchestra[1] =ser;
            Orchestra[1].out();

            Wind_Instrument wer = new Wind_Instrument(2050,2003,"O, i am sorry");
            wer.dzyn();
            Orchestra[2] =wer;
            Orchestra[2].out();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
