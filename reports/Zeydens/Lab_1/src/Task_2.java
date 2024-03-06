//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isNumeric(String[] str) {
        for (String line : str) {
            if (!line.matches("-?\\d+(\\.\\d+)?")) {
                return false;
            }
        }
        return true;
    }
    public static long[] removeElement(long[] array, long element) {
        if (array.length < 1) {
            System.out.print("Array is too small\n");
            return new long[0];
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == element) {
                long[] temp = new long[array.length - 1];
                for (int j = 0; j < i; ++j) {
                    temp[j] = array[j];
                }
                for (int j = i + 1; j < array.length; ++j) {
                    temp[j - 1] = array[j];
                }
                return temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.print("Invalid number of arguments, expected 2 and more\n");
            return;
        }
        if(!isNumeric(args)) {
            System.out.print("Can process only numbers\n");
            return;
        }
        long[] array = new long[args.length - 1];
        long element = Long.parseLong(args[args.length - 1]);
        System.out.print("Element to delete: " + element + "\nFrom array: ");
        for(int i = 0; i < args.length - 1; ++i) {
            array[i] = Long.parseLong(args[i]);
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
        array = removeElement(array, Long.parseLong(args[args.length - 1]));
        System.out.print("Processed array: ");
        for (long elem : array) {
            System.out.print(elem + " ");
        }
    }
}