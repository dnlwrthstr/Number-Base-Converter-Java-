import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String dwalin = scanner.next();
        String balin = scanner.next();
        String thorin = scanner.next();

        BigDecimal sum = new BigDecimal(dwalin).add(new BigDecimal(balin).add(new BigDecimal(thorin)));
        System.out.println(sum);
    }
}