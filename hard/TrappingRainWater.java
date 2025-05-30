package hard;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0; // No water can be trapped
        }

        int n = height.length;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left max
                } else {
                    waterTrapped += leftMax - height[left]; // Calculate trapped water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right max
                } else {
                    waterTrapped += rightMax - height[right]; // Calculate trapped water
                }
                right--;
            }
        }

        return waterTrapped; // Return the total trapped water
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result = solution.trap(height);
        System.out.println("Water trapped: " + result); // Output: Water trapped: 6
    }

}
