package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (Character c : chars) {
            if (Character.isLetterOrDigit(c)) {
                characterList.add(c);
            }
        }
        for (int i = 0; i < characterList.size() / 2; i++) {
            Character a=characterList.get(i);
            Character b=characterList.get(characterList.size()-i-1);
            if(!a.equals(b)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
