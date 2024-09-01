import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] x = setupMatrix();
        showMatrix(x);
        bestSellerOfYear(x);
        averagePerVendor(x);
    }

    public static int[][] createMatrix() {
        return new int[15][12];
    }

    public static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public static int[][] setupMatrix() {
        int[][] matrix = createMatrix();

        fillMatrix(matrix);

        return matrix;
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void bestSellerOfYear(int[][] matrix) {

        int[][] results = new int[15][1];
        for (int i = 0; i < matrix.length; i++) {
            
            int count = 0;
            
            for (int j = 0; j < matrix[i].length; j++) {
                count += matrix[i][j];
            }
            
            results[i][0] = count;
        }

        int count = 0;
        int xAxis = 0;
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[0].length; j++) {

                if (results[i][j] > count) {
                    count = results[i][j];
                    xAxis = i;
                }

            }
        }

        System.out.println("El mejor vendedor fue el vendedor numero: " + (xAxis + 1) + ", con un total de ventas de: " + count);
    }

    public static int[] allSellsVendor5(int[][] matrix) {

        int[] results = new int[12];

        for (int i = 0; i < matrix[4].length; i++) {
            results[i] = matrix[4][i];
        }

        return results;
    }

    public static void lowestSellsMonth(int[][] matrix) {

        int[] monthly = new int[12];

        for (int i = 0; i < matrix[0].length; i++) {

            int count = 0;

            for (int j = 0; j < matrix.length; j++) {
                count += matrix[j][i];
            }

            monthly[i] = count;
        }


        int count = monthly[0];
        int pos = 0;

        for (int i = 0; i < monthly.length; i++) {

            if (monthly[i] < count) {
                count = monthly[i];
                pos = i;
            }
        }

        System.out.println("El mes con menos ventas fue el numero: " + (pos+1) + ", con total de ventas: " + count);

    }

    public static int monthlyAverage(int[][] matrix) {

        int monthly = 0;

        for (int i = 0; i < matrix.length; i++) {

            int count = 0;

            for (int j = 0; j < matrix[0].length; j++) {
                count += matrix[j][i];
            }

            monthly += count;
        }

        return monthly / 12;

    }

    public static void averagePerVendor(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            int count = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                count += matrix[i][j];
            }

            System.out.println("El promedio de ventas del vendedor: " + (i+1) +", fue de: " + (count / 12));
        }

    }
}


