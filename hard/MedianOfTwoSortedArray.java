package hard;

import java.util.Arrays;

public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums3[] = new int[nums1.length + nums2.length];

        double output = 0;
        int j = 0;

        for (int i = 0; i < nums3.length; i++) {
            if (i < nums1.length) {
                nums3[i] = nums1[i];
            } else {

                nums3[i] = nums2[j];
                j++;
            }
        }

        Arrays.sort(nums3);

        if (nums3.length % 2 == 0) {

            double mid1 = nums3[(nums3.length) / 2];

            System.out.println("mid1: " + mid1);
            double mid2 = nums3[(nums3.length) / 2 - 1];
            System.out.println("mid2: " + mid2);
            output = (mid1 + mid2) / 2;
        } else {

            output = (double) (nums3[nums3.length / 2]);
        }

        return output;

    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray solution = new MedianOfTwoSortedArray();
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of two sorted arrays: " + result);
    }

}
