package com.itheima.datastructure.queue;

import java.util.List;

public class E01Leetcode102 {
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //
    // }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            System.out.print(n + " ");
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
    }

}
