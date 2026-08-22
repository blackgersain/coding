package com.korales.career.bfs;

import java.util.*;

public class LevelOrderSum {

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

    public List<Integer> level_order_sum(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        List<Integer> sumPerLevel = new ArrayList<>();

        while (!deque.isEmpty()) {
            int sumLevel = 0;
            int levelSize = deque.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = deque.pollFirst();
                sumLevel += treeNode.val;

                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
            }

            sumPerLevel.add(sumLevel);
        }

        return sumPerLevel;
    }
}
