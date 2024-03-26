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

       // char[] passwordArray = console.readPassword("Введите пароль: ", "*");
        //String password = new String(passwordArray);

        // Очистите массив пароля после использования
       // Arrays.fill(passwordArray, ' ');


//        LocalDateTime currentDateTime = LocalDateTime.now();
//        System.out.println(currentDateTime);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedDateTime = currentDateTime.format(formatter);
//        System.out.println(formattedDateTime);
//
//        String dateString = "2024-12-12";
//        String timeString = "14:23:15";
//
//        LocalDate date = LocalDate.parse(dateString);
//        LocalTime time = LocalTime.parse(timeString);
//
//        LocalDateTime dateTime = LocalDateTime.of(date, time);
//        System.out.println(dateTime);
//
//        if(currentDateTime.isBefore(dateTime)){
//            System.out.println("Before");
//        }else{
//            System.out.println("After");
//        }
//
//        StationTree.insert("Technical University","Second");
//        StationTree.insert("Technical University","Second13");
//        StationTree.insert("Second","Second2");
//        StationTree.insert("Second","Second5");
//        StationTree.insert("Second2","Station 4");
//        StationTree.insert("Station 4","Red");
//        StationTree.insert("Red","Finch");
//        Node find = StationTree.findParent("Second");
//        System.out.println(find.getStation());
//        System.out.println("\n\n");
//        //StationTree.showToRoot("Finch");
//        //RailwayOffice.addTrain();
//        //RailwayOffice.addTrain();
//        StationTree.show();


//        Person admin = new Administrator();
//        RailwayOffice.AddParagraph(admin);
//        RailwayOffice.AddParagraph(admin);
//        //RailwayOffice.AddParagraph(admin);
//        RailwayOffice.showSchedule();
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
                showAdministrators();
                break;
            case "3":
                showAdministrators();
                System.out.print("Enter administrator's number: ");
                index = read.nextInt()-1;
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
    public static void showAdministrators(){
        System.out.println("Administrators list: ");
        int i = 0;
        for(Administrator current : admins){
            ++i;
            System.out.println("\t"+i+". "+current.getName());
        }
    }

}