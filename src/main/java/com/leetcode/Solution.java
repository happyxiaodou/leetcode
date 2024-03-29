package com.leetcode;

import com.leetcode.domain.ListNode;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution {


    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    ListNode successor = null; // 后驱节点

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            // 相当于反转前 right 个元素
            return reverseN(head, right);
        }
        head.next.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }


    public ListNode reverseAB(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start, end;
        start = end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        ListNode newHeader = reverseAB(start, end);
        start.next = reverseKGroup(end, k);

        return newHeader;
    }

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = head.next;
            fast = head.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean f = traverse(right.next);
        f = f & (right.val == left.val);
        left = left.next;
        return f;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        Solution solution = new Solution();
        listNode = solution.reverseN(listNode, 4);

        while (listNode != null) {
            System.err.println(listNode.val);
            listNode = listNode.next;
        }
        System.err.println("");
    }


}
