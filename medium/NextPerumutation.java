package medium;

public class NextPerumutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;

            // Find the first element larger than nums[i]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // Swap the found elements
            swap(nums, i, j);
        }

        // Reverse the elements after index i
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        NextPerumutation solution = new NextPerumutation();
        int[] nums = { 1, 2, 3 };
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
