package com.leetcode;

import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, valid = 0;
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        int start = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            System.out.println("window: [" + left + "," + right + ")");
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char ch = s.charAt(left);
                left++;
                if (need.containsKey(ch)) {
                    if (windows.get(ch).equals(need.get(ch))) {
                        valid--;
                    }
                    windows.put(ch, windows.get(ch) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start+len);
    }

    public static void main(String[] args) {
        MinWindow window = new MinWindow();
        System.err.println(window.minWindow("ADOBECODEBANC", "ABC"));
    }
}
