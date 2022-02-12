package com.leetcode;

import java.util.Arrays;

public class ModifiedArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        Differ differ = new Differ(length);
        for (int i = 0; i < updates.length; i++) {
            differ.update(updates[i][0], updates[i][1], updates[i][2]);
            System.err.println(Arrays.toString(differ.getReal()));
        }
        return differ.getReal();
    }

    class Differ {
        private int[] d;

        Differ(int len) {
            d = new int[len];
        }

        public void update(int start, int end, int update) {
            d[start] = d[start] + update;
            if (end + 1 < d.length) {
                d[end + 1] = d[end + 1] - update;
            }
        }

        public int[] getReal() {
            int[] f = new int[d.length];
            f[0] = d[0];
            for (int i = 1; i < d.length; i++) {
                f[i] = f[i - 1] + d[i];
            }
            return f;
        }
    }

    public static void main(String[] args) {
        ModifiedArray modifiedArray = new ModifiedArray();
        int[][] u = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] i = modifiedArray.getModifiedArray(5, u);
        System.err.println("");
    }
}
