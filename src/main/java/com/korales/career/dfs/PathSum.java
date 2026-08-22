package com.korales.career.dfs;

public class PathSum {

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

    public Boolean pathSum(TreeNode root, Integer target) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return target == root.val;
        }

        target = target - root.val;

        return pathSum(root.left, target) || pathSum(root.right, target);
    }
}
