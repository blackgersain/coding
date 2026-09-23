package com.korales.career.dfs;

public class CalculateTilt {

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

    public Integer calculateTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return calculateTiltNode(root) + calculateTiltNode(root.left) + calculateTiltNode(root.right);
    }

    public Integer calculateTiltNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int tilt = Math.abs(sum(node.left) - sum(node.right));

        System.out.println("node:" + node.val + ", tilt:" + tilt);

        return tilt;
    }

    public Integer sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + sum(node.left) + sum(node.right);
    }
}
