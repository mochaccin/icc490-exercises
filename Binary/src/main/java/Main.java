import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        menu();
    }

    public static void menu() {

        boolean run = true;

        do {
            System.out.println("[0] Convertir a binario \n[1] Convertir a decimal \n[Otro Numero] Salir");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 0 -> convertToBinary();
                case 1 -> convertToDecimal();
                default -> {
                    run = false;
                }
            }

        } while (run);
    }

    public static void convertToBinary() {

        BinaryCalculator bCalc = new BinaryCalculator();
        System.out.println("Introduzca el numero decimal a convertir.");

        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        System.out.println("La representacion binaria de: " + value + ", es: " + bCalc.toBinary(value));

    }

    public static void convertToDecimal() {

        BinaryCalculator bCalc = new BinaryCalculator();
        System.out.println("Introduzca la representacion binaria a convertir.");

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        System.out.println("La representacion binaria de: " + value + ", es: " + bCalc.toDecimal(value));

    }
}
