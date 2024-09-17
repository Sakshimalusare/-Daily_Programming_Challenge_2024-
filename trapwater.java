import java.util.Scanner;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

       
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

       
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

    
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of bars in the histogram:");
        int n = sc.nextInt();
        int[] height = new int[n];

        System.out.println("Enter the heights of the bars:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = trap(height);
        System.out.println("Total amount of water that can be trapped: " + result);

        sc.close();
    }
}
