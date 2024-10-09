import java.util.Scanner;
import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of coin types: ");
        int n = scanner.nextInt();
        
        int[] coins = new int[n];
        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();

        int result = coinChange(coins, amount);
t
        if (result == -1) {
            System.out.println("It is not possible to make up the amount with the given coins.");
        } else {
            System.out.println("Minimum number of coins required: " + result);
        }

        scanner.close();
    }
}
