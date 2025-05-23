package BinaryTree;

import java.util.*;

    /* Return the lowest visible node from each vertical column 
        when looking from the bottom of a binary tree. */

public class BottomView {
    public List<Integer> bottomView(TreeNode root){
        List<Integer> list = new ArrayList<>(); // Final result list

        if(root == null) return list; // If the tree is empty, return empty list

        TreeMap<Integer, Integer> map = new TreeMap<>(); // Stores latest node seen at each vertical level (sorted)

        Queue<Pair> q = new LinkedList<Pair>(); // Queue for BFS traversal
        q.offer(new Pair(root, 0)); // Start from root at vertical level 0

        while(!q.isEmpty()){
            Pair temp = q.poll(); // Get next node and its vertical position
            TreeNode node = temp.node;
            int ver = temp.vertical;

            // Always update value for this vertical level (overwrites previous one)
            map.put(ver, node.data);

            // Go to left child with vertical - 1
            if(node.left != null) 
                q.offer(new Pair(node.left, ver - 1));

            // Go to right child with vertical + 1
            if(node.right != null) 
                q.offer(new Pair(node.right, ver + 1));
        }

        // Add bottom view values from left to right
        for(int val : map.values()){
            list.add(val);
        }
        
        return list; // Return the bottom view
    }
}

// Helper class to keep track of a node and its vertical position
class Pair {
    TreeNode node;
    int vertical;

    Pair(TreeNode node, int vertical){
        this.node = node;
        this.vertical = vertical;
    }
}
