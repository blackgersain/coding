package com.korales.career.dfs;

public class ValidateBinarySearchTree {

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
    
    public Boolean validateBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return validateBST(root.left, Integer.MIN_VALUE, root.val) && validateBST(root.right, root.val, Integer.MAX_VALUE);
    }

    public Boolean validateBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }

        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }
}
