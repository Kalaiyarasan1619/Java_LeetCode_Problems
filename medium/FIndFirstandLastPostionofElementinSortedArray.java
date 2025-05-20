package medium;

public class FIndFirstandLastPostionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                firstPosition = mid;
                right = mid - 1; // Continue searching in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstPosition;
    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastPosition = mid;
                left = mid + 1; // Continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastPosition;
    }

    public static void main(String[] args) {
        FIndFirstandLastPostionofElementinSortedArray solution = new FIndFirstandLastPostionofElementinSortedArray();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("First and last positions of " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}