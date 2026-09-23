package com.korales.career.dfs;

public class PassingValuesDown {

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

    public Integer goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode node, int greatest) {
        if (node == null) {
            return 0;
        }

        int count = 1;

        if (node.val < greatest) {
            count = 0;
        }

        greatest = Math.max(greatest, node.val);

        return count + goodNodes(node.left, greatest) + goodNodes(node.right, greatest);
    }
}
