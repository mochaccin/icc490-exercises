import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] x = setupMatrix();
        //si es cuadrado magico -> System.out.println(isMagicCube(new int[][]{{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}));
        showMatrix(x);
        System.out.println(isMagicCube(x));
    }

    public static int[][] createMatrix() {
        return new int[3][3];
    }

    public static void fillMatrix(int[][] matrix) {
        List<Integer> options = Arrays.asList(1,2,3,4,5,6,7,8,9);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * options.size());
            }
        }
    }

    public static int[][] setupMatrix() {
        int[][] matrix = createMatrix();

        fillMatrix(matrix);

        return matrix;
    }

    public static boolean isMagicCube(int[][] matrix) {

        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            count += matrix[0][i];
        }

        for (int i = 1; i < 3; i++) {

            int rowCount = 0;

            for (int j = 0; j < 3; j++) {
                rowCount = rowCount + matrix[i][j];
            }

            if (rowCount != count) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {

            int columnCount = 0;

            for (int j = 0; j < 3; j++) {
                columnCount = columnCount + matrix[j][i];
            }

            if (columnCount != count) {
                return false;
            }
        }

        int mainDiagonalCount = matrix[0][0] + matrix[1][1] + matrix[2][2];
        if (mainDiagonalCount != count) {
            return false;
        }

        int secondaryDiagonalCount = matrix[0][2] + matrix[1][1] + matrix[2][0];
        return secondaryDiagonalCount == count;
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
