package BinaryTree;

import java.util.*;

public class BurningTree {
    
    // Step 1: This function helps us:
    // - Find the node where fire starts
    // - Save each node’s parent so we can go backward too
    public static TreeNode parentTrack(TreeNode root, Map<TreeNode, TreeNode> map, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode target = null; // node where fire starts

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // If current node is the start node, save it
            if (curr.data == start) target = curr;

            // Save left child’s parent as current node
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.offer(curr.left); // add left child to queue
            }

            // Save right child’s parent as current node
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.offer(curr.right); // add right child to queue
            }
        }

        return target; // return the node where fire begins
    }


    // Main function to calculate time to burn the whole tree
    public static int minTime(TreeNode root, int target) {
        Map<TreeNode, TreeNode> parent = new HashMap<>(); // stores child → parent
        TreeNode tar = parentTrack(root, parent, target); // find target and fill map

        if (tar == null) return 0; // if start node not found, return 0

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tar); // start fire from target node

        int maxTime = 0; // counter to track seconds passed
        Set<TreeNode> set = new HashSet<>();
        set.add(tar); // mark target as visited (burned)

        // BFS to simulate fire spreading each second
        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0; // track if fire spreads in this second

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Try to burn left child if not already burned
                if (curr.left != null && !set.contains(curr.left)) {
                    q.offer(curr.left);
                    set.add(curr.left);
                    flag = 1;
                }

                // Try to burn right child if not already burned
                if (curr.right != null && !set.contains(curr.right)) {
                    q.offer(curr.right);
                    set.add(curr.right);
                    flag = 1;
                }

                // Try to burn parent if not already burned
                if (parent.get(curr) != null && !set.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    set.add(parent.get(curr));
                    flag = 1;
                }
            }

            // If fire spread to any node this second, increase time
            if (flag == 1) maxTime++;
        }

        return maxTime; // total time to burn entire tree
    }

}
