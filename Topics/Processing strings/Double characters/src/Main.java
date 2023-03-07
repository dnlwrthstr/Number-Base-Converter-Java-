import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        char[] ca = word.toCharArray();
        for (char c : ca) {
          System.out.printf("%s%s", c, c);
        }
        System.out.print("\n");
    }
}