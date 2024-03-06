import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public static String randomString(int length, boolean asciiOnly) {
        if (length < 0) {
            throw new IllegalArgumentException();
        }
        if(length == 0) {
            return "";
        }
        String string = "";
        Random random = new Random();
        if (asciiOnly) {
            for (int i = 0; i < length; ++i) {
                int num = random.nextInt(128);
                string += (char) num;
            }
            return string;
        } else {
            for (int i = 0; i < length; ++i) {
                int num = random.nextInt(65536);
                string += (char) num;
            }
            return string;
        }
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.print("Wrong number of arguments: expected 2\n");
            return;
        }
        if(!isNumeric(args[0])) {
            System.out.print("Expected number as the first parameter. Accepted: " + args[0] + "\n");
            return;
        }
        if(!args[1].equals("true") && !args[1].equals("false")) {
            System.out.print("Expected 'true' or 'false' as the second argument. Accepted: " + args[1] + "\n");
            return;
        }
        String str = randomString(Integer.parseInt(args[0]), Boolean.parseBoolean(args[1]));
        System.out.print(str + "\n");
    }
}