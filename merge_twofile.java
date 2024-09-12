import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {
    public static void mergeArrays(int[] arr1, int[] arr2, int m, int n) {
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of arr1: ");
        int m = sc.nextInt();
        System.out.print("Enter the size of arr2: ");
        int n = sc.nextInt();
        int[] arr1 = new int[m];
        System.out.println("Enter elements of arr1 (sorted):");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[n];
        System.out.println("Enter elements of arr2 (sorted):");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        mergeArrays(arr1, arr2, m, n);
        System.out.println("After merging:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        
        sc.close();
    }
}
