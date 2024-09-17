import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        
        int sum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1))); 

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIdx : map.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
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

        List<int[]> result = findZeroSumSubarrays(arr);
        
        if (result.isEmpty()) {
            System.out.println("No subarrays found with sum zero.");
        } else {
            System.out.println("Subarrays with sum zero (start index, end index):");
            for (int[] subarray : result) {
                System.out.println(Arrays.toString(subarray));
            }
        }

        sc.close();
    }
}
