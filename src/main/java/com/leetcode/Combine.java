package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> r = new LinkedList<>();
        com(n, k, 0, r);
        return result;

    }

    public void com(int n, int k, int start, LinkedList<Integer> r) {
        if (r.size() == k) {
            result.add(new LinkedList<>(r));
            return;
        }
        for (int i = start; i < n; i++) {
            r.add(i);
            com(n, k, i + 1, r);
            r.removeLast();
        }

    }

    public static void main(String[] args) {

    }
}
