package hard;

import java.util.Stack;

public class LargestRectangleinHistogram {

    public static void main(String[] args) {
        LargestRectangleinHistogram sol = new LargestRectangleinHistogram();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(sol.largestRectangleArea(heights)); // Output: 10
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;}}