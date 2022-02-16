package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)) {
                windows.put(r, windows.getOrDefault(r,0) + 1);
                if (windows.get(r).equals(need.get(r))) {
                    valid++;
                }
            }
            while (right - left > s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (windows.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    windows.put(l, windows.get(l) - 1);
                }
            }
        }
        return  false;
    }
}
