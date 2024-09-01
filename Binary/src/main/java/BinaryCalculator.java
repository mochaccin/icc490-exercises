public class BinaryCalculator {

    public BinaryCalculator() {

    }

    public String toBinary(int decimal) {

        if (decimal == 0) {
            return "Error!";
        }

        if (decimal > 255) {
            return "Error!";
        }

        StringBuilder binary = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        if (binary.toString().length() < 8) {
            return String.format("%0" + 8 + "d", Integer.parseInt(binary.toString()));
        }

        return binary.toString();

    }

    public int toDecimal(String binary) {

        if (binary.length() != 8) {
            throw new RuntimeException("Error!");
        }

        if (!binary.matches("\\d+")) {
            throw new RuntimeException("Error!");
        }

        int count = 0;
        int baseValue = 128;

        for (int i = 0; i < binary.length(); i++) {

            if (binary.toCharArray()[i] == '1') {
                count += baseValue;

            }

            baseValue /= 2;

        }

        return count;
    }
}
