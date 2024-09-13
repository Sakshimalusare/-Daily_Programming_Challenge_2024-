import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ArrayList<Integer> leaders = findLeaders(arr, n);
        System.out.println("Leaders: " + leaders);
        scanner.close();
    }
    public static ArrayList<Integer> findLeaders(int[] arr, int n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[n - 1]; 
        leaders.add(maxFromRight);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = leaders.size() - 1; i >= 0; i--) {
            result.add(leaders.get(i));
        }
        
        return result;
    }
