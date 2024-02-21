import java.util.Scanner;

public class Main3 {
    public static String abbreviate(String str) { //Задание 3
        String abreviate = "";
        String abb[] = str.split(" ");
        for (int i = 0; i < abb.length; i++) {
            abreviate += abb[i].charAt(0);
        }
        
        return abreviate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Задание 3
        System.out.println("Введите строку для получения аббревиатуры: ");
        String buff = scanner.nextLine();
        String abbr = abbreviate(buff);
        System.out.println(abbr);
    }
}
