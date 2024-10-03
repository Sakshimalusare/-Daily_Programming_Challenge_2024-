import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaxSlidingWindow {
    
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peek()];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Enter the size of the sliding window (k):");
        int k = sc.nextInt();
        
        int[] result = maxSlidingWindow(arr, k);
        
        System.out.print("Maximum elements in each sliding window: ");
        for (int max : result) {
            System.out.print(max + " ");
        }
        
        sc.close();
    }
}
