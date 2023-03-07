import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int power = scanner.nextInt();
        int scale = scanner.nextInt();
        String input = scanner.next();

        BigDecimal number = new BigDecimal(input);
        number = number.setScale(scale, RoundingMode.FLOOR);
        number = number.pow(power);

        System.out.println(number);

    }
}