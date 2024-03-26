package RailwayTicketOffice;

import RailwayTicketOffice.Person;

import java.util.Scanner;

public class Administrator extends Person {
    private String name;
    private String password;
    public Administrator(String name, String password){
        type = Const.ADMINISTRATOR;
        this.name = name;
        this.password = password;
    }
    public void Action(){
        Scanner read = new Scanner(System.in);
        String action = "";
        System.out.print("Enter password: ");
        action = read.next();
        System.out.println();
        if(!password.equals(action)){
            System.out.println("Wrong password");
            return;
        }
        System.out.println("\tADMINISTRATOR");
        do{
            action = read.next();
            Menu(action);
        }
        while(!action.equals("quit"));
    }
    public void Menu(String action){
        Scanner read = new Scanner(System.in);
        switch (action.toLowerCase()){
            case "1":
                RailwayOffice.showSchedule();
                break;
            case "2":
                RailwayOffice.AddParagraph(this);
                break;
            case "3":
                StationTree.show();
                break;
            case "4":
                StationTree.show();
                System.out.println("Enter parent station");
                String parent = read.nextLine();
                System.out.println("Enter new station name");
                String new_station = read.nextLine();
                StationTree.insert(parent, new_station);
                break;
            case "5":
                RailwayOffice.addTrain();
                break;
            case "6":
                ShowTrainList();
                break;
            case "7":
                ShowTrainList();
                System.out.println("Enter train number in list to delete (-1 to cancel)");
                int number = read.nextInt();
                if(number == -1){
                    return;
                }
                RailwayOffice.trains.remove(number);
                break;
            case "quit":
                return;
            default:
                System.out.println("1 - Show schedule\n2 - Add paragraph\n3 - Show stations tree\n4 - Add station\n5 - Add train\n6 - Show train list\n7 - Remove train\n%any% - help\nquit to exit");
                break;
        }
    }
    public String getName(){
        return name;
    }
    void ShowTrainList(){
        for(int i = 0; i < RailwayOffice.trains.size(); ++i){
            System.out.println(i + ". Train number: " + RailwayOffice.trains.get(i).getNumber() + " with capacity: " + RailwayOffice.trains.get(i).getCapacity());
        }
    }

}
