package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
    List<List<Integer>> rest = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> r = new LinkedList<>();
        su(nums, 0, r);
        return rest;
    }

    public void su(int[] nums, int start, LinkedList<Integer> r) {
        rest.add(new LinkedList<>(r));
        for (int i = start; i < nums.length; i++) {
            r.add(nums[i]);
            su(nums, i + 1, r);
            r.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> r = subsets.subsets(new int[]{1, 2, 3});
        System.out.println();
    }
}


