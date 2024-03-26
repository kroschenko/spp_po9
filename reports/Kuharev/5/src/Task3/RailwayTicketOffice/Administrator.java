package RailwayTicketOffice;

import RailwayTicketOffice.Person;

import java.util.Scanner;

public class Administrator implements Person {
    int type;
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
        while(!action.equals("quit")){
            action = read.next();
            Menu(action);
        }
    }
    public void Menu(String action){
        switch (action){
            case "":
                break;
            default:
                System.out.println("1 - Show schedule\n2 - Add paragraph\n3 - Show stations tree\n4 - Add station\n5 - Add train\n6 - Remove train\n%any% - help\nquit to exit");
                break;
        }
    }
    public String getName(){
        return name;
    }
}
