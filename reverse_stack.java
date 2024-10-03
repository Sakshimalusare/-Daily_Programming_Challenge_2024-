import java.util.Stack;
import java.util.Scanner;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, top);
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("Enter integers for the stack (enter 'done' to finish):");
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                stack.push(sc.nextInt());
            } else if (sc.next().equalsIgnoreCase("done")) {
                break;
            }
        }
        
        reverseStack(stack);
        
        System.out.println("Reversed stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        sc.close();
    }
}
