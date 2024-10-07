import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciDP {

    public static BigInteger fibonacci(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            result = a.add(b); 
            a = b;              
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer n ");
        int n = scanner.nextInt();

        if (n < 0 || n > 1000) {
            System.out.println("Please enter a value between 0 and 1000.");
        } else {
            BigInteger fibonacciNumber = fibonacci(n);
            System.out.println("The " + n + "-th Fibonacci number is: " + fibonacciNumber);
        }

        scanner.close();
    }
}
