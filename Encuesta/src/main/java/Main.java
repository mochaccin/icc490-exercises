import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        char[][] x = setupMatrix(10);
        System.out.println(Arrays.deepToString(x));
        System.out.println(howManyWomenDisapprove(x));
        System.out.println(howManyMenApprove(x));
        System.out.println(totalVoters(x));
        System.out.println(percentageOfApprovers(x));
    }

    public static char[][] createVoteMatrix(int y) {
        return new char[2][y];
    }

    public static void fillVoteMatrix(char[][] matrix) {

        char[] options = {'s','n','x'};
        Random rnum = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = options[rnum.nextInt(options.length)];
            }
        }
    }

    public static char[][] setupMatrix(int y) {
        char[][] matrix = createVoteMatrix(y);

        fillVoteMatrix(matrix);

        return matrix;
    }

    public static int howManyMenApprove(char[][] matrix) {

        int count = 0;

        for (int i = 0; i < matrix[0].length; i++) {

            if (matrix[0][i] == 's') {
                count++;
            }

        }

        return count;
    }

    public static int howManyWomenDisapprove(char[][] matrix) {

        int count = 0;

        for (int i = 0; i < matrix[1].length; i++) {

            if (matrix[1][i] == 'n') {
                count++;
            }

        }

        return count;
    }

    public static int totalVoters(char[][] matrix) {
        return matrix.length * matrix[0].length;
    }

    public static double percentageOfApprovers(char[][] matrix) {

        double count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 's') {
                    count++;
                }

            }
        }

        return count * 100 / totalVoters(matrix);
    }
}
