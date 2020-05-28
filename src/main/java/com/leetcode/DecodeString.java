package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString {

    int ptr;

    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {//是否为数字
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.add(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stk.add(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                Stack<String> sub = new Stack<>();
                while (!"[".equals(stk.peek())) {
                    sub.add(stk.pop());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.pop();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.pop());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.add(t.toString());
            }
        }
        return getString(stk);
    }

    public String getString(Stack<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }


    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.err.println(decodeString.decodeString("3[a]2[bc]"));
    }
}
