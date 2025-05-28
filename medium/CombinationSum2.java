package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;

    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return; // No valid combination
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result); // Move to the next index
            current.remove(current.size() - 1); // Backtrack
        }

    }

    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + result);
    }

}
