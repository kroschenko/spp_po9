import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        double[] array = new double[args.length];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <= args.length - 1; i++) {
            array[i] = Double.parseDouble(args[i]);
        }
        System.out.println("Введите индекс и число: ");
        array = Add(array, scanner.nextInt(), scanner.nextInt());
        for (double i : array) {
            System.out.print(i+ " ");
        }
    }

    static double[] Add(double[] array, int index, double value) {
        double[] temp = new double[array.length + 1];
        for (int i = 0, j = 0; i < array.length + 1; i++) {
            if (i == index) {
                temp[i] = value;
                continue;
            }
            temp[i] = array[j];
            j++;
        }
        return array = temp;
    }
}

