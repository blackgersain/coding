package com.korales.career.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {

     class TreeNode {
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
    
    public List<List<Integer>> pathSum(TreeNode root, Integer target) {
        List<List<Integer>> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        List<Integer> path = new ArrayList<>();
        paths.add(path);

        paths(root, target, paths, path);

        return paths;
    }

    public void paths(TreeNode node, Integer target, List<List<Integer>> paths, List<Integer> path) {
        if (node == null) {
            return ;
        }

        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (target != node.val) {
                paths.remove(path);
            }

            return ;
        }

        target -= node.val;

        if (node.left != null && node.right != null) {
            List<Integer> newPath = new ArrayList<>(path);

            paths.add(newPath);
            paths(node.left, target, paths, path);
            paths(node.right, target, paths, newPath);
        }
        else {
            TreeNode nonNullNode = (node.left != null) ? node.left : node.right;

            paths(nonNullNode, target, paths, path);
        }
    }
}
