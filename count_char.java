import java.util.HashMap;
import java.util.Scanner;

public class SubstringsWithKDistinctCharacters {

    private static int countAtMostKDistinct(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> charCount = new HashMap<>();
        int start = 0, count = 0;
        
        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            
            while (charCount.size() > k) {
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++;
            }
            
            count += end - start + 1;
        }
        
        return count;
    }

    public static int countSubstringsWithKDistinct(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        int result = countSubstringsWithKDistinct(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);
        sc.close();
    }
}
