package medium;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum; // Exact match found
                }
            }
        }

        return closestSum;

    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        int result = solution.threeSumClosest(nums, target);
        System.out.println("Three sum closest result: " + result);
    }

}
