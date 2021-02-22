package com.leetcode;

public class Connect {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        getNext(root.left, root.right);
        return root;
    }

    public void getNext(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        getNext(left.left, left.right);
        getNext(right.left, right.right);
        getNext(left.right, right.left);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);


        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Connect connect = new Connect();
        connect.connect(node);

        System.err.println(node);
    }
}
