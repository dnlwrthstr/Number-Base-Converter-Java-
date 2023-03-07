package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(
                    "Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String input = scanner.nextLine();

            if (Objects.equals(input, "/exit")) {
                exit = true;
            } else {
                String[] bases = input.split(" ");
                int sourceBase = Integer.parseInt(bases[0]);
                int targetBase = Integer.parseInt(bases[1]);

                boolean back = false;

                do {
                    System.out.print(
                            "Enter number in base " + sourceBase + " to convert to base "
                                    + targetBase + " (To go back type /back) ");
                    String number = scanner.nextLine();
                    if (Objects.equals(number, "/back")) {
                        back = true;
                    } else {
                        String[] parts = number.split("\\.");
                        BigInteger integer = new BigInteger(parts[0], sourceBase);
                        String integerPart = integer.toString(targetBase);
                        String fractionalpart = "";

                        if (parts.length > 1) {
                            String fractional = parts[1];
                            BigDecimal decFractional = convertToDecimal(fractional, sourceBase);
                            fractionalpart = convertFractionToBase(decFractional, targetBase);
                            //fractionalpart = fractionalpart.equals("")? "00000": fractionalpart;
                        }
                            System.out.print("Conversion result: " + integerPart.toLowerCase());
                            if (!fractionalpart.equals("")) {
                                System.out.print("." + fractionalpart);
                            }
                            System.out.println("\n");
                    }
                } while (!back);
            }
        } while (!exit);
    }

    public static String convertFractionToBase(BigDecimal fraction, int targetBase) {
        StringBuilder result = new StringBuilder();
        BigDecimal base = new BigDecimal(targetBase);
        int count = 0;
        while (fraction.compareTo(BigDecimal.ZERO) > 0 && count < 5) {
            fraction = fraction.multiply(base);
            BigInteger integerPart = fraction.toBigInteger();
            fraction = fraction.subtract(new BigDecimal(integerPart));
            int digit = integerPart.intValueExact();
            if (digit >= 10) {
                result.append((char) ('A' + digit - 10));
            } else {
                result.append(digit);
            }
            count++;
        }
        StringBuilder formattedResult = new StringBuilder(result.toString().toLowerCase());
        if (formattedResult.length() < 5) {
            int diff = 5 - formattedResult.length();
            formattedResult.append("0".repeat(Math.max(0, diff)));
        }
        return formattedResult.toString();
    }

    public static BigDecimal convertToDecimal(String number, int base) {

        BigDecimal decimal = new BigDecimal(String.valueOf(BigDecimal.ZERO));
        BigDecimal baseDecimal = new BigDecimal(base);

        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("Invalid base: " + base);
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int digit = Character.getNumericValue(c);
            decimal = decimal.add(BigDecimal.valueOf(digit).divide(baseDecimal.pow(i + 1), MathContext.DECIMAL128));
        }

        return decimal;
    }
}
