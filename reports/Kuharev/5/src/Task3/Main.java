import RailwayTicketOffice.*;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Administrator> admins;
    public static void main(String[] args) {
        admins = new ArrayList<Administrator>();
        Scanner read = new Scanner(System.in);
        System.out.println("Enter 'start' to begin");
        String action = "";
        while(!action.equals("quit")){
            action = read.next();
            Menu(action);
        }
    }
    public static void Menu(String action){
        Scanner read = new Scanner(System.in);
        String name = "";
        int index = 0;
        Console console = System.console();
        if (console == null) {
            System.err.println("Консоль недоступна");
            System.exit(1);
        }
        switch (action){
            case "quit":
                return;
            case "1":
                System.out.print("Enter administrator's name: ");
                name = read.next();
                System.out.println();
                char[] passwordArray = console.readPassword("Enter new password: ", "*");
                String password = new String(passwordArray);
                admins.add(new Administrator(name, password));
                Arrays.fill(passwordArray, ' ');

                break;
            case "2":
                System.out.println("Administrators list: ");
                int i = 0;
                for(Administrator current : admins){
                    ++i;
                    System.out.println("\t"+i+". "+current.getName());
                }
                break;
            case "3":
                System.out.print("Enter administrator's number: ");
                index = read.nextInt();
                Administrator admin;
                try{
                    admin = admins.get(index);
                }catch (Exception ex){
                    System.out.println("No such administrator");
                    Menu("2");
                    break;
                }
                admin.Action();
                break;
            case "4":
                Passenger user = new Passenger();
                user.Action();
                break;
            default:
                System.out.println("1 - Add administrator\n2 - Show administrators\n3 - Login as 'Administrator'\n4 - Enter as user\n%any% - help\nquit to exit");
                break;
        }
    }
}