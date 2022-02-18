package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> result = new LinkedList<>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                windows.put(r, windows.getOrDefault(r, 0) + 1);
                if (windows.get(r).equals(need.get(r))) {
                    valid++;
                }
            }
            System.out.println("window: [ " + left + "," + right + ")");
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (windows.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    windows.put(l, windows.get(l) - 1);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        List r = findAnagrams("baa", "aa");
        System.err.println("");
    }
}
