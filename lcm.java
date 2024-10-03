import java.util.Scanner;

public class LCMCalculator {

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long n, long m) {
        return (n / gcd(n, m)) * m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers N and M:");
        long N = sc.nextLong();
        long M = sc.nextLong();
        long result = lcm(N, M);
        System.out.println("Least Common Multiple (LCM) of " + N + " and " + M + " is: " + result);
        sc.close();
    }
}
