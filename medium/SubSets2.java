package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubSets2 {

    public static void main(String[] args) {
        SubSets2 sol = new SubSets2();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = sol.subsetsWithDup(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
        // Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}