package RailwayTicketOffice;

public class Train {
    static private int next_number = 0;
    final private int number;
    private int capacity;

    public Train(int capacity){
        ++next_number;
        number = next_number;
        this.capacity = capacity;
    }
    public int getNumber(){
        return number;
    }
    public int getCapacity(){
        return capacity;
    }
    public void boardPassenger(){
        if(capacity < 1){
            System.out.println("Train is full");
            return;
        }
        --capacity;
    }
}
