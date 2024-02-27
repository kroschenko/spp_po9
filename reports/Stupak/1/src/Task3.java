import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите символ и кол-во повторений: ");

        System.out.println(repeat(scanner.next().charAt(0), scanner.nextInt()));
    }

    static String repeat(char ch, int repeat) {
        String str = "";

        for (int i = 0; i < repeat; i++) {
            str += ch;
        }

        return str;
    }
}
