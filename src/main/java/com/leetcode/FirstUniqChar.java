package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> c = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (c.containsKey(a)) {
                c.put(a, -1);
            } else {
                c.put(a, i);
            }
        }
        for(Map.Entry<Character,Integer> entry:c.entrySet()){
            if(entry.getValue()!=-1){
                return entry.getValue();
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.err.println(firstUniqChar("loveleetcode"));
    }


}
