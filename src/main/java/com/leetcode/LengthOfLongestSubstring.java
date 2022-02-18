package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            windows.put(r, windows.getOrDefault(r, 0) + 1);
            while (windows.getOrDefault(r, 0) > 1) {
                char l = s.charAt(left);
                left++;
                windows.put(l, windows.getOrDefault(l, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;

    }
}
