public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[args.length];

        for (int i = 0; i <= args.length - 1; i++) {
            array[i] = Integer.parseInt(args[i]);
        }

        if (args.length % 2 == 1) {
            System.out.println("Mediana: " + array[args.length / 2]);
        } else {
            System.out.println("Mediana: " + ((array[args.length / 2 - 1] + array[args.length / 2]) / 2));
        }
    }
}
