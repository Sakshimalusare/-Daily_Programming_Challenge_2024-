import java.util.Scanner;

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) { 
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String reversed = reverseWords(input);

        System.out.println("Reversed words:");
        System.out.println(reversed);

        sc.close();
    }
}
