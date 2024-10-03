import java.util.*;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');
        for (char ch : s.toCharArray()) {
            if (matchingBrackets.containsKey(ch)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != matchingBrackets.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with parentheses:");
        String input = sc.nextLine();

        if (isValid(input)) {
            System.out.println("The string is valid.");
        } else {
            System.out.println("The string is not valid.");
        }

        sc.close();
    }
}
