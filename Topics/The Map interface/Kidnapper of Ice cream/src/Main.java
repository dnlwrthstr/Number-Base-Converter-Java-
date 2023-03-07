import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : firstLine.split(" ")) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        boolean canConstruct = true;
        for (String word : secondLine.split(" ")) {
            if (!wordCounts.containsKey(word) || wordCounts.get(word) == 0) {
                canConstruct = false;
                break;
            }
            wordCounts.put(word, wordCounts.get(word) - 1);
        }

        if (canConstruct) {
            System.out.println("You get money");
        } else {
            System.out.println("You are busted");
        }
    }
}
