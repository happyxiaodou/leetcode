package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {

    List<List<Integer>> rest = new LinkedList<>();


    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        p(nums, path);
        return rest;
    }


    public void p(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            rest.add(new LinkedList<>(path));
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            p(nums, path);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> r = permute.permute(new int[]{1, 2, 3});
        System.out.println("");
    }
}
