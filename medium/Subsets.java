package medium;

import java.util.List;
import java.util.ArrayList;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = s.subsets(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
        // Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}