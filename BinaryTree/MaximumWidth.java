package BinaryTree;

import java.util.*;

    /* Maximum Width of a Binary Tree:
        To find the widest level in the binary tree.
        In other words, find the level (row) that has the largest number of nodes,
        including gaps (nulls) between nodes.


    In a binary tree, we don’t normally store indices. But to measure width properly,
    we pretend (or simulate) that the binary tree is a complete binary tree, where:

        -> The root has index 0.
        -> The left child of node at index i has index 2*i + 1.
        -> The right child of node at index i has index 2*i + 2.
        
        These are "virtual indices" – they don’t exist in the real tree, we assign them temporarily to help calculate widths.
        This helps us figure out how wide a level really is, even if some nodes are missing (i.e., sparse levels).
     */
    
public class MaximumWidth {
    public int maxWidth(TreeNode root){
        // If tree is empty, width is 0
        if(root == null) return 0;
        
        int maxWidth = 0;

        // Queue to do level-by-level traversal, storing node and its index
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(root, 0)); // Start with root at index 0

        while(!q.isEmpty()){
            int size = q.size(); // Number of nodes in current level
            int min = q.peek().idx; // Minimum index in this level
            int first = 0, last = 0;

            for(int i = 0; i < size; i++){
                int curr_idx = q.peek().idx - min; // Normalize index to prevent overflow
                TreeNode node = q.peek().node;
                q.poll();

                if(i == 0) first = 0;          // First node at this level
                if(i == size - 1) last = curr_idx; // Last node at this level

                // Push left child with its virtual index
                if(node.left != null) 
                    q.offer(new Pair(node.left, (curr_idx * 2) + 1));

                // Push right child with its virtual index
                if(node.right != null) 
                    q.offer(new Pair(node.right, (curr_idx * 2) + 2));
            }

            // Update max width
            maxWidth = Math.max(maxWidth, (last - first + 1));
        }

        return maxWidth; // Return the largest width found
    }
}

// Class to hold node and its index in queue
class Pair {
    TreeNode node;
    int idx;

    Pair(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}
