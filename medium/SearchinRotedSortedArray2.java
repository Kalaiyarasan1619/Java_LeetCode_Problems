package medium;

public class SearchinRotedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            // If duplicates, just move left pointer
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchinRotedSortedArray2 sol = new SearchinRotedSortedArray2();
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(sol.search(nums, 0)); // Output: true
        System.out.println(sol.search(nums, 3)); // Output: false
    }
}