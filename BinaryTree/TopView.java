package BinaryTree;

import java.util.*;

    /* Return the first visible node from each vertical column
         when looking from the top of a binary tree. */

public class TopView {
    public List<Integer> topView(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // Final answer list
        TreeMap<Integer, Integer> map = new TreeMap<>(); // Stores topmost nodes by vertical level (sorted)

        if(root == null) return list; // Edge case: empty tree

        Queue<Pair> q = new LinkedList<>(); // Queue for BFS
        q.offer(new Pair(root, 0)); // Start from root with vertical level 0

        while(!q.isEmpty()){
            Pair temp = q.poll(); // Get next node and its vertical position
            TreeNode node = temp.node;
            int ver = temp.vertical;

            // If this vertical column hasn't been seen yet, add this node
            if(!map.containsKey(ver)) 
                map.put(ver, node.data);

            // Go to left child with vertical - 1
            if(node.left != null) 
                q.offer(new Pair(node.left, ver - 1));

            // Go to right child with vertical + 1
            if(node.right != null) 
                q.offer(new Pair(node.right, ver + 1));
        }

        // Collect all top view nodes from left to right
        for(int val : map.values()){
            list.add(val);
        }

        return list; // Return the top view
    }
}

// Helper class to hold node and its vertical level
class Pair {
    TreeNode node;
    int vertical;

    Pair(TreeNode node, int vertical){
        this.node = node;
        this.vertical = vertical;
    }
}

