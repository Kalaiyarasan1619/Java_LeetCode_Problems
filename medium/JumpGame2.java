package medium;

public class JumpGame2 {

    public int jump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0; // No jumps needed for empty array
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest reachable index

            if (i == currentEnd) { // Time to make a jump
                jumps++;
                currentEnd = farthest; // Update the end of the current jump
            }
        }

        return jumps;

    }

    public static void main(String[] args) {
        JumpGame2 solution = new JumpGame2();
        int[] nums = { 2, 3, 1, 1, 4 };
        int result = solution.jump(nums);
        System.out.println("Minimum jumps to reach the end: " + result);
    }

}
