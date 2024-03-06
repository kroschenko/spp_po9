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

    public static void minMaxFromArgs(String[] args) {
        if (args.length < 1 && !isNumeric(args)) {
            System.out.println("Unappropriate string\n");
        }
            float min = Float.MAX_VALUE, max = Float.MIN_VALUE;
            for (int i = 0; i < args.length; ++i) {
                float temp = Float.parseFloat(args[i]);
                if (temp <= min) min = temp;
                if (temp >= max) max = temp;
            }
            System.out.println("\nmin = " + min + " max = " + max + "\nmax - min: " + (max - min));
    }

    public static void main(String[] args) {
        minMaxFromArgs(args);
    }
}