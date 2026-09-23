package com.korales.career.dfs;

public class DiameterBinaryTree {

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
    
    public Integer maxDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxDiameter = maxDepth(node.left) + maxDepth(node.right);

        maxDiameter = Math.max(maxDiameter, maxDiameter(node.left));
        maxDiameter = Math.max(maxDiameter, maxDiameter(node.right));

        return maxDiameter;
    }

    public Integer maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(1 + maxDepth(node.left), 1 + maxDepth(node.right));
    }
}
