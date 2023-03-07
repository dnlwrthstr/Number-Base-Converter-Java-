import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int newScale = scanner.nextInt();
        BigDecimal bigDec = new BigDecimal(number);

        System.out.println(bigDec.setScale(newScale, RoundingMode.HALF_DOWN));
    }   
}