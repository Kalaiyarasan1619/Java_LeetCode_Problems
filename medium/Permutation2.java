package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue; // Skip used elements
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue; // Skip duplicates

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            used[i] = false; // Backtrack
            current.remove(current.size() - 1); // Remove last element
        }
    }

    public static void main(String[] args) {
        Permutation2 solution = new Permutation2();
        int[] nums = { 1, 1, 2 };
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println("Unique permutations: " + result);
    }

}
