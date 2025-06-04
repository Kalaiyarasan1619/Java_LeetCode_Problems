package medium;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0; // Maximum index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If current index is beyond max reach, we cannot proceed
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update max reach
            if (maxReach >= nums.length - 1) {
                return true; // If we can reach or exceed the last index
            }
        }
        return false; // If we finish the loop without reaching the last index
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println("Can jump to the end: " + solution.canJump(nums)); // Output: true
    }

}
