package RailwayTicketOffice;

import RailwayTicketOffice.Person;

import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.concurrent.ScheduledFuture;

public class Passenger implements Person {
    int type;
    public Passenger(){
        type = Const.USER;
    }
    public void Action(){
        System.out.println("\tUser");
        Scanner read = new Scanner(System.in);
        String action = "";
        while(!action.equals("quit")){
            action = read.next();
            Menu(action);
        }
    }
    public void Menu(String action){//реализация
        switch (action){
            case "quit":
                return;
            case "1":
                RailwayOffice.showSchedule();
                break;
            case "2":
                RailwayOffice.findsuitableTrain();
                break;
            case "3":
                RailwayOffice.chooseTicket(RailwayOffice.findsuitableTrain(), this);
                break;
            default:
                System.out.println("1 - Show schedule\n2 - Find suitable trains\n3 - Make request\n%any% - help\nquit to exit");
                break;
        }
    }
}
