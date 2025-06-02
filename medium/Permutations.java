package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue; // Skip used elements

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            used[i] = false; // Backtrack
            current.remove(current.size() - 1); // Remove last element
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = solution.permute(nums);
        System.out.println("Permutations: " + result);
    }

}
