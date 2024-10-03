import java.util.HashMap;
import java.util.Scanner;

public class FirstElementKTimes {
    
    public static int findFirstKTimes(int[] arr, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr) {
            if (countMap.get(num) == k) {
                return num;
            }
        }
        
        return -1;
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
        
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        
        int result = findFirstKTimes(arr, k);
        System.out.println("First element that appears exactly " + k + " times: " + result);
        
        sc.close();
    }
}
