import java.util.Locale;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println("Введите символ и кол-во повторений: ");
        System.out.println(repeat(scanner.next().charAt(0), scanner.nextDouble()));
    }

    static String repeat(char ch, double repeat) {
        String str = "";

        for (int i = 0; i < (int)repeat; i++) {
            str += ch;
        }

        return str;
    }
}
