package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OpenLock {


    private String plus(String target, int j) {
        char[] ch = target.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minus(String target, int j) {
        char[] ch = target.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }


    private void all(String target) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                System.out.println(cur);
                if (cur == null || cur.equals(target)) {
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plus(cur, j);
                    String down = minus(cur, j);
                    q.offer(up);
                    q.offer(down);
                }
            }
        }
    }

    public int openLock(String[] deadends, String target) {
        int path = 0;
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (dead.contains(cur)) {
                    continue;
                }
                if (cur == null || cur.equals(target)) {
                    return path;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plus(cur, j);
                    if(visited.add(up)){
                        q.offer(up);
                    }
                    String down = minus(cur, j);
                    if(visited.add(down)){
                        q.offer(down);
                    }
                }
                path++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        openLock.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
    }
}
