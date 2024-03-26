package RailwayTicketOffice;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class RailwayOffice {
    static public ArrayList<Train> trains = new ArrayList<Train>();
    static int bill_number = 0;

    //static private ArrayList<String> stations;
    private static boolean isExit;
//    public RailwayOffice(){
//        trains = new ArrayList<Train>();
//        isExit = false;
//    }

    public static void AddParagraph(Person person){
        if(person.type != Const.ADMINISTRATOR){
            System.out.println("You don't have a permission");
            return;
        }
        isExit = false;
        System.out.println("\tAdd paragraph ('-1' to exit)");
        Schedule.addParagraph(readStation(), readTrain(), readDateTime(), readTicketsAmount(), readTicketPrice());
    }

    public static String readStation(){
        Scanner read = new Scanner(System.in);
        System.out.print("Enter station name: ");
        String station_name = read.next();
        if(station_name.equals("-1")){
            isExit = true;
            return null;
        }
        if(StationTree.findParent(station_name) == null){
            System.out.println(station_name + " station doesn't exist, but you can create it.");
            return readStation();
        }else{
            return station_name;
        }
    }
    public static Train readTrain(){
        int train_number = 0;
        if(isExit){
            return null;
        }
        Scanner read = new Scanner(System.in);
        System.out.print("Enter train number: ");
        try{
            train_number = read.nextInt();
        }catch(Exception ex){
            System.out.println("Wrong number");
            return readTrain();
        }
        if(train_number == -1){
            isExit = true;
            return null;
        }
        int find = findTrain(train_number);
        if(find < 0){
            System.out.println("Train №"+train_number+" doesn't exist, but you can create it.");
            return readTrain();
        }
        return trains.get(find);
    }
    public static LocalDateTime readDateTime(){
        if(isExit){
            return null;
        }
        Scanner read = new Scanner(System.in);
        System.out.print("Enter date in next format '2024-01-01': ");
        String dateString = read.next();
        if(dateString.equals("-1")){
            isExit = true;
            return null;
        }
        System.out.print("Enter time in next format '12:00:00': ");
        String timeString = read.next();
        if(timeString.equals("-1")){
            isExit = true;
            return null;
        }
        LocalDate date;
        LocalTime time;
        LocalDateTime dateTime = LocalDateTime.now();
        try{
            date = LocalDate.parse(dateString);
        }
        catch (Exception ex){
            System.out.println("Wrong date format");
            return readDateTime();
        }
        try{
            time = LocalTime.parse(timeString);
        }
        catch (Exception ex){
            System.out.println("Wrong time format");
            return readDateTime();
        }
        dateTime = LocalDateTime.of(date, time);
        return dateTime;
    }
    public static int readTicketsAmount(){
        if(isExit){
            return -1;
        }
        int tickets_amount = 0;
        Scanner read = new Scanner(System.in);
        System.out.print("Enter tickets amount: ");
        try{
            tickets_amount = read.nextInt();
        }catch(Exception ex){
            System.out.println("Wrong number");
            return readTicketsAmount();
        }
        if(tickets_amount == -1){
            isExit = true;
            return tickets_amount;
        }
        return tickets_amount;
    }
    public static int readTicketPrice(){
        int ticket_price = 0;
        if(isExit){
            return -1;
        }
        Scanner read = new Scanner(System.in);
        System.out.print("Enter ticket price: ");
        try{
            ticket_price = read.nextInt();
        }catch(Exception ex){
            System.out.println("Wrong number");
            return readTicketPrice();
        }
        if(ticket_price == -1){
            isExit = true;
            return ticket_price;
        }
        return ticket_price;
    }
    public static void addTrain(){
        Scanner read = new Scanner(System.in);
        int capacity = 0;
        System.out.print("Enter train capacity: ");
        try{
            capacity = read.nextInt();
        }catch(Exception ex){
            System.out.println("Wrong capacity");
            addTrain();
        }
        Train new_train = new Train(capacity);
        trains.add(new_train);
    }
    public static void removeTrainByNumber(int train_number){
        int index = findTrain(train_number);
        if(index > -1){
            trains.remove(index);
        }
    }
    public static int findTrain(int number){
        if(trains == null){
            return -1;
        }
        for(int i = 0; i < trains.size(); ++i){
            if(trains.get(i).getNumber() == number){
                return i;
            }
        }
        return -1;
    }
    public static ArrayList<Integer> findsuitableTrain(){
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        String station;
        String date, time;
        Scanner read = new Scanner(System.in);
        System.out.println("Ticket search:");
        System.out.print("Enter station name: "); station = read.next();
        if(StationTree.findParent(station) == null){
            System.out.println("Can't find station");
            findsuitableTrain();
        }
        System.out.print("Enter date in format \"2000-01-01\" or press [Enter] to choose current: "); date = read.next();
        if(date.length() > 8){
            try {
                currentDate = LocalDate.parse(date);
            }catch(Exception ex){
                System.out.println("Wrong date");
                findsuitableTrain();
            }
        }
        System.out.print("Enter time in format \"12:00:00\" or press [Enter] to choose current: "); time = read.next();
        if(date.length() > 6){
            try {
                currentTime = LocalTime.parse(time);
            }catch(Exception ex){
                System.out.println("Wrong time");
                findsuitableTrain();
            }
        }
        LocalDateTime dateTime = LocalDateTime.of(currentDate, currentTime);
        return Schedule.findTicket(station, dateTime);
    }
    public static void chooseTicket(ArrayList<Integer> indexes, Passenger passenger){
        int number = 0; boolean isHas = false;
        String bill = "";
        Scanner read = new Scanner(System.in);
        System.out.print("Enter ticket number (-1 to exit): ");
        try{
            number = read.nextInt()-1;
        }catch (Exception ex){
            System.out.println("Wrong number");
        }
        if(number == -1){
            return;
        }
        for(int i = 0; i < indexes.size(); ++i){
            if(number == indexes.get(i)){
                isHas = true;
            }
        }
        if(!isHas){
            System.out.println("Index not in list");
            chooseTicket(indexes, passenger);
        }
        System.out.println("Your route: ");
        ArrayList<String> path = new ArrayList<String>();
        path = StationTree.showToRoot(Schedule.station.get(number));
        ++bill_number;
        DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Schedule.setTicketsAmount(number, Schedule.getTicketsAmount(number)-1);
        bill = "\tBill №000" + bill_number + "\nTicket number: " + Schedule.tickets_amount.get(number) +
                "\nDate: " + Schedule.date_time.get(number).format(date_formatter) +
                "\nTime: " + Schedule.date_time.get(number).format(time_formatter) +
                "\nDestination: " + Schedule.station.get(number) + "\nRoute: ";
        for(int i = path.size()-1; i >= 0; --i){
            if(i > path.size()-2){
                bill += path.get(i)+" -> ";
            }else{
                bill += path.get(i);
            }
        }
        bill += "\nPrice: $" + Schedule.ticket_price.get(number);

        System.out.println(bill);
        System.out.println("\nDo you want to print your 'Bill'(y/n)?");
        if(!read.next().toLowerCase().equals("n")){
            IFile.WriteFile(bill, "output.txt");
        }
    }

    public static void showSchedule(){
        Schedule.ShowSchedule();
    }
    private static class Schedule{
        static private ArrayList<String> station = new ArrayList<String>();
        static private ArrayList<Train> train = new ArrayList<Train>();
        static private ArrayList<LocalDateTime> date_time = new ArrayList<LocalDateTime>();
        static private ArrayList<Integer> tickets_amount = new ArrayList<Integer>();
        static private ArrayList<Integer> ticket_price = new ArrayList<Integer>();

        public static void ShowSchedule(){
            if(station == null){
                System.out.println("Schedule is empty");
                return;
            }
            System.out.println("\tSchedule");
            DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedDate, formattedTime;
            for(int i = 0; i < station.size(); ++i){
                formattedDate = date_time.get(i).format(date_formatter);
                formattedTime = date_time.get(i).format(time_formatter);
                System.out.println((i+1)+"."+station.get(i)+"\n -Date: "+formattedDate+"\n -Time: "+formattedTime+"\n -Ticket price: "+ticket_price.get(i) +"\n -Tickets amount: "+tickets_amount.get(i) + "\n -Train number: "+train.get(i).getNumber());
            }
        }
        public static void addParagraph(String newstation, Train newtrain, LocalDateTime dateTime, Integer newtickets_amount, Integer newticket_price){
            if(isExit){
                System.out.println("Exit");
                isExit = false;
                return;
            }
            boolean isAdded = false;
            for(int i = 0; i < station.size(); ++i){
                if(dateTime.isBefore(date_time.get(i)) && !isAdded){
                    isAdded = true;
                    station.add(i, newstation);
                    train.add(i, newtrain);
                    date_time.add(i, dateTime);
                    tickets_amount.add(i, newtickets_amount);
                    ticket_price.add(i, newticket_price);
                }
            }
            if(!isAdded){
                station.add(newstation);
                train.add(newtrain);
                date_time.add(dateTime);
                tickets_amount.add(newtickets_amount);
                ticket_price.add(newticket_price);
            }
            System.out.println("Paragraph added");
        }
        public static void setTicketsAmount(int index, int value){
            tickets_amount.set(index, value);
        }
        public static int getTicketsAmount(int index){
            return tickets_amount.get(index);
        }
        private static ArrayList<Integer> findTicket(String station_name, LocalDateTime time){
            ArrayList<Integer> indexes = new ArrayList<Integer>();
            DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedDate, formattedTime;
            boolean isFound = false;
            for(int i = 0; i < station.size(); ++i){
                if(station.get(i).equals(station_name) && date_time.get(i).isAfter(time) && tickets_amount.get(i) > 0){
                    isFound = true; indexes.add(i);
                    formattedDate = date_time.get(i).format(date_formatter);
                    formattedTime = date_time.get(i).format(time_formatter);
                    System.out.println((i+1)+"."+station.get(i)+"\n -Date: "+formattedDate+"\n -Time: "+formattedTime+"\n -Ticket price: "+ticket_price.get(i) +"\n -Tickets amount: "+tickets_amount.get(i) + "\n -Train number: "+train.get(i).getNumber());
                }
            }
            if(!isFound){
                System.out.println("Cannot find match");
            }
            return indexes;
        }
    }
}
