import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static int calculate(char[] ca) {
        int sum = 0;
        for (char  c : ca) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }

    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String number = s.nextLine();
        String regexp = "[0-9]{6}";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(number);
        boolean b = m.matches();


        if(b) {
            char[] ca1 = number.substring(0,3).toCharArray();
            char[] ca2 = number.substring(3).toCharArray();

            if( calculate(ca1) == calculate(ca2)) {
                System.out.println("Lucky");
            } else {
                System.out.println("Regular");
            }

        } else {
            System.out.println("Not a valid number.");
        }
    }
}