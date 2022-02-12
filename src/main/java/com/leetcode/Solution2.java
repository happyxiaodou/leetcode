package com.leetcode;


public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }


    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart < preEnd) {
            return null;
        }
        int rootValue = preorder[postStart];
        int leftRootValue = preorder[postStart + 1];


        int index = -1;
        for (int i = postStart; i <= postEnd; i++) {
            if (leftRootValue == postorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - postStart + 1;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, postStart + 1, preStart + leftSize, postorder, postStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1,preEnd, postorder, index + 1, preEnd - 1);
        return root;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
