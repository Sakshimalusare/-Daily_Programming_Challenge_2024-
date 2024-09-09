import java.util.*;

class Sort_0s_1s_2s {
    public void bruteForce(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            boolean flag = false;
            for(int j=0;j < n-1-i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                break;
            }
        }
    }

    public void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);

            quicksort(nums, low, pivotIndex - 1);
            quicksort(nums, pivotIndex + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;  
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void dnf(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        Sort_0s_1s_2s sorter = new Sort_0s_1s_2s();
        
        // Test cases
        int[] nums1 = {0, 1, 2, 1, 0, 2, 1, 0};
        int[] nums2 = {0, 1, 2}
        sorter.dnf(nums1);
        sorter.dnf(nums2);
        System.out.println("Sorted array 1: " + Arrays.toString(nums1));
        System.out.println("Sorted array 2: " + Arrays.toString(nums2));
    }
}
