package hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, minStart = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                if (need.get(c) > 0)
                    count--;
                need.put(c, need.get(c) - 1);
            }
            right++;
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }
                char l = s.charAt(left);
                if (need.containsKey(l)) {
                    need.put(l, need.get(l) + 1);
                    if (need.get(l) > 0)
                        count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mws.minWindow(s, t)); // Output: "BANC"
    }
}