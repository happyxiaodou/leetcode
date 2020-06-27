package com.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            if (d == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    int h = nums[j];
                    if (h != 0) {
                        nums[i] = h;
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }

    }


    public static void moveZeroes2(int[] nums) {
        int i, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] i = {0, 1, 0, 3, 12};
        moveZeroes2(i);
        System.err.println(StringUtils.join(i, ','));
    }
}
