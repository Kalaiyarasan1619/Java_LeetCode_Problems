package easy;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;

    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        int length = solution.removeElement(nums, val);
        System.out.println("Length of array after removing element: " + length);
        System.out.print("Modified array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
