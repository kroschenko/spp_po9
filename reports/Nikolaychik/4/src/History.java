import java.util.Date;


public class History {
    final static short in_type=0,out_type=1,to_type=2;
    public Date date;
    public short type;
    public int to_id,from_id;
    public long size;
    History(int size,short type,int from_id,int to_id){
        this.date = new Date();
        this.type = type;
        this.size = size;
        this.to_id = to_id;
        this.from_id = from_id;
    }
}
