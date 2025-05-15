package BinaryTree;

import java.util.*;


public class ZigzagLevelTraversal {

/* Print the tree level by level, left to right,
    then right to left, and keep flipping like a zig-zag */

    List<Integer> zigZagTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // final answer

        if(root == null) return list; // empty tree

        boolean flag = true; // true = left to right, false = right to left

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // start from root

        while(!q.isEmpty()) {
            int len = q.size(); // how many nodes in this level
            List<Integer> temp = new ArrayList<>(); // hold values for this level

            for(int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                temp.add(node.data); // collect node value

                if(node.left != null) q.offer(node.left);   // add left child
                if(node.right != null) q.offer(node.right); // add right child
            }

            if(!flag) Collections.reverse(temp); // if right-to-left, reverse

            list.addAll(temp); // add level to final list
            flag = !flag;      // flip direction for next level
        }

        return list;
    }

}
