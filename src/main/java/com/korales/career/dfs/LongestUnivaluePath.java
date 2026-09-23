package com.korales.career.dfs;

public class LongestUnivaluePath {

     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
 }
    
    public Integer longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int univaluePath = maxDepth(root.left, root.val) + maxDepth(root.right, root.val);

        univaluePath = Math.max(univaluePath, longestUnivaluePath(root.left));
        univaluePath = Math.max(univaluePath, longestUnivaluePath(root.right));

        return univaluePath;
    }

    public Integer maxDepth(TreeNode node, Integer value) {
        if (node == null) {
            return 0;
        }
        if (node.val == value) {
            return Math.max(1 + maxDepth(node.left, value), 1 + maxDepth(node.right, value));
        }

        return 0;
    }
}
