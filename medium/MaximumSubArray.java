package medium;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Initialize with the first element
        int currentSum = nums[0]; // Current subarray sum

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // Update current sum
            maxSum = Math.max(maxSum, currentSum); // Update max sum if needed
        }

        return maxSum; // Return the maximum subarray sum
    }

    public static void main(String[] args) {
        MaximumSubArray solution = new MaximumSubArray();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Maximum subarray sum: " + solution.maxSubArray(nums)); // Output: 6
    }

}
