package medium;

public class RemoveDuplicateFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray2 sol = new RemoveDuplicateFromSortedArray2();
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int len = sol.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        // Output: 0 0 1 1 2 3 3
    }

}