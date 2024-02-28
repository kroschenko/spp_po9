public class Task1 {
    public static void main(String[] args) throws Exception {
        if(args.length<2){
            throw new Exception("Arguments < 2");
        }
        int[] array = new int[args.length];

        for (int i = 0; i <= args.length - 1; i++) {
            array[i] = Integer.parseInt(args[i]);
        }

        if(array[0]>=array[1]){
            throw new Exception("Array disordered");
        }

        if (args.length % 2 == 1) {
            System.out.println("Median: " + array[args.length / 2]);
        } else {
            System.out.println("Median: " + ((array[args.length / 2 - 1] + array[args.length / 2]) / 2));
        }
    }
}
