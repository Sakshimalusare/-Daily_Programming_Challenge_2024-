import java.util.Scanner;

public class MissingNumber {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        return totalSum - arrSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array (n-1): ");
        int nMinus1 = scanner.nextInt();
        int[] arr = new int[nMinus1];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < nMinus1; i++) {
            arr[i] = scanner.nextInt();
        }

        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number: " + missingNumber);

        scanner.close();  
    }
}
