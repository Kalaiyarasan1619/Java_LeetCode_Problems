package medium;

import java.util.List;
import java.util.ArrayList;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations comb = new Combinations();
        List<List<Integer>> result = comb.combine(4, 2);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        // Output: [ [1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4] ]
    }
}