package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    List<List<Integer>> rest=new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> r=new LinkedList<>();
        t(graph,0,r);
        return rest;
    }

    public  void t(int[][] graph,int s,LinkedList<Integer> r){
        r.add(s);
        int n =graph.length;
        if(s == n-1){
            // 到达终点
            rest.add(new LinkedList<>(r));
            r.removeLast();
            return;
        }
        for(int v: graph[s]){
            t(graph,v,r);
        }
        r.removeLast();
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(isAnagram("ba", "aa"));
    }
}
