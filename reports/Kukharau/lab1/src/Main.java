public class Main {
    public static void main(String[] args){
        String array_task1 = args[0];
        String cs = args[1];
        System.out.println("Task1: ");
        LabTasks lab1 = new LabTasks();
        lab1.showUnique(lab1.ParceStringToIntArray(array_task1));

        System.out.println("\nTask2: ");
        double[][] matrix = {{1, 3, 5}, {4, 6, 8}, {1, 4, 7}};
        lab1.SetMatrix(matrix);
        System.out.println("Initial matrix: ");
        lab1.Show();
        System.out.println("\nRandom element position matrix: ");
        lab1.randomPetrubations();
        lab1.Show();

        System.out.println("\nTask3: ");
        if(lab1.isAllLowerCase(cs)){
            System.out.print("All symbols are lower case\n");
        }else{
            System.out.print(lab1.isAllLowerCase("Not all symbols are lower case\n"));
        }
    }
}