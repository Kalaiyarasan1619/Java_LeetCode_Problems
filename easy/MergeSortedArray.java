package easy;

public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        sol.merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // Output: 1 2 2 3 5 6
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];}}}