package com.leetcode;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {


     public static int reverse(int x) {
        long result = 0;
        while (x % 10 != 0) {
            int pop = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            result = result * 10 + pop;

        }
        return Math.toIntExact(result);
    }

    //太暴力
    public static int revers1(int x) {
        StringBuilder sx = new StringBuilder();
        if (x > 0) {
            sx.append(x);
            sx.reverse();
            try {
                return Integer.parseInt(sx.toString());
            } catch (Exception e) {
                return 0;
            }
        } else {
            sx.append(0 - x);
            sx.reverse();
            try {
                return 0 - Integer.parseInt(sx.toString());
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.err.println(reverse(1534236469));
    }

}
