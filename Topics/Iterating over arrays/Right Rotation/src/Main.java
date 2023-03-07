import java.util.Arrays;
import java.util.Scanner;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        int n = arr.length;
        steps %= n; // adjust k in case it is greater than n
        if (steps == 0) return; // no rotation needed
        int[] temp = new int[steps];
        System.arraycopy(arr, n - steps, temp, 0, steps);
        System.arraycopy(arr, 0, arr, steps, n - steps);
        System.arraycopy(temp, 0, arr, 0, steps);
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}