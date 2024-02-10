import java.util.Scanner;

public class Main2 {
    public static double[][] transpose(double[][] matrix) { //Задание 2
        double[][] temp = new double[matrix[0].length][matrix.length]; //выделяем память под транспонированную матрицу

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][i] = matrix[i][j];
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Задание 2
        int x, y;
        System.out.println("Введите количество строк: ");
        x = scanner.nextInt();
        System.out.println("Введите количество столбцов: ");
        y = scanner.nextInt();
        System.out.println("Заполните матрицу: ");

        double[][] matrix = new double[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] newMatrix;
        newMatrix = transpose(matrix);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
