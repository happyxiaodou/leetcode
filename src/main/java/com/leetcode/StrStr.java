package com.leetcode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {
    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr(String haystack, String needle) {
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        if (needleChars.length == 0) {
            return 0;
        }
        char first = needleChars[0];
        int max = haystackChars.length - needleChars.length;
        for (int i = 0; i < haystackChars.length; i++) {
            if (haystackChars[i] != first) {
                while (++i <= max && haystackChars[i] != first) ;
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + needleChars.length - 1;
                for (int k = 1; j < end && haystackChars[j] == needleChars[k]; j++, k++)
                    ;
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.err.println(strStr1("a", "a"));
    }
}
