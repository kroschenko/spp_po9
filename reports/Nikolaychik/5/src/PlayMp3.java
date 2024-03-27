import javazoom.jl.player.*;
import java.io.FileInputStream;

public class PlayMp3 {

    public PlayMp3(String path){//C:\Users\strau\Downloads\

        try{

            FileInputStream fis = new FileInputStream(path);
            Player playMP3 = new Player(fis);

            playMP3.play();
            playMP3.close();
            fis.close();
        }catch(Exception e){System.out.println(e);}
    }

}
