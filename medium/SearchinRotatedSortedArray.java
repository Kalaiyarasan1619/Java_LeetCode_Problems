package medium;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray solution = new SearchinRotatedSortedArray();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }

}
