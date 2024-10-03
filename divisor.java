import java.util.Scanner;

public class DivisorCount {

    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer N ");
        int N = sc.nextInt();
        int result = countDivisors(N);
        System.out.println("Total number of divisors of " + N + " is: " + result);
        sc.close();
    }
}
