import java.util.Scanner;

public class FindDuplicateNumber {
    
    public static int findDuplicate(int[] arr) {
        int tortoise = arr[0];
        int hare = arr[0];
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);
        tortoise = arr[0];
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }
        
        return hare; 
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array (n+1): ");
        int nPlusOne = scanner.nextInt();
        int[] arr = new int[nPlusOne];
        System.out.println("Enter " + nPlusOne + " elements (values between 1 and " + (nPlusOne - 1) + "):");
        for (int i = 0; i < nPlusOne; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate number: " + duplicate);

        scanner.close();
    }
}
