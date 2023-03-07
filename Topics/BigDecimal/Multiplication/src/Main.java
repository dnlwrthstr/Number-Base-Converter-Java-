import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();

        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);

        System.out.println(dec1.multiply(dec2));
    }
}