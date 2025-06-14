package medium;

import java.util.List;
import java.util.ArrayList;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode sol = new GrayCode();
        List<Integer> result = sol.grayCode(2);
        System.out.println(result); // Output: [0, 1, 3, 2]
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | (1 << i));
            }
        }
        return res;
    }}