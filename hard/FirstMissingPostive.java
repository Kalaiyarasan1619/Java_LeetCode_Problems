package hard;

public class FirstMissingPostive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1; // If the array is empty, the first missing positive is 1
        }

        int n = nums.length;

        // Step 1: Replace negative numbers and zeros with a number larger than n
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1; // Replace with a number larger than n
            }
        }

        // Step 2: Use the index as a hash to mark the presence of numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // Mark as negative to indicate presence
            }
        }

        // Step 3: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // The first missing positive is at index i
            }
        }

        return n + 1; // If all numbers from 1 to n are present, return n + 1
    }

    public static void main(String[] args) {
        FirstMissingPostive solution = new FirstMissingPostive();
        int[] nums = { 3, 4, -1, 1 };
        int result = solution.firstMissingPositive(nums);
        System.out.println("First missing positive integer: " + result); // Output: 2
    }

}
