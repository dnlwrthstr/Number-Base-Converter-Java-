import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String numberRange = "((1[0-9]{2})|(2([0-4][0-9]|5[0-5]))|([0-9]{1,2}))";
        String regex = "(" + numberRange + "\\.){3}" + numberRange;
        if (ip.matches(regex)) {
        //if (ip.matches(numberRange)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}