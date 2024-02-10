import java.util.ArrayList;
import java.util.Random;

public class Main1 {

    public static void task1(ArrayList<Integer> nums) { //Задание 1
        Random random = new Random();
        ArrayList<Integer> temp = new ArrayList<>(nums);

        for (int i = 0; i < nums.size(); i++) {
            int buff = random.nextInt(temp.size());
            System.out.print(temp.get(buff) + " ");
            temp.remove(buff);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayL = new ArrayList<Integer>();
        for (int i = 0; i < args.length; i++) {
            int num = Integer.parseInt(args[i]);
            arrayL.add(num);
        }
        task1(arrayL);
    }
}
