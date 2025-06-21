package BinaryTree;

import java.util.*;

public class AllNodeDistanceK {
    
    // Step 1: Track each node's parent
    public void parentTrack(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();

            // Save parent info for left child
            if(curr.left != null) {
                q.offer(curr.left);
                parent.put(curr.left, curr);
            }

            // Save parent info for right child
            if(curr.right != null) {
                q.offer(curr.right);
                parent.put(curr.right, curr);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parentTrack(root, parent); // Create parent map

        int currLevel = 0; // Start BFS from level 0
        Set<TreeNode> set = new HashSet<>(); // To avoid visiting same node twice

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target); // Start from the target node
        set.add(target);

        while(!q.isEmpty()) {
            int size = q.size();

            if(currLevel == k) break; // If reached level k, stop
            currLevel++;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Visit left child
                if(curr.left != null && !set.contains(curr.left)) {
                    q.offer(curr.left);
                    set.add(curr.left);
                }

                // Visit right child
                if(curr.right != null && !set.contains(curr.right)) {
                    q.offer(curr.right);
                    set.add(curr.right);
                }

                // Visit parent node
                if(parent.get(curr) != null && !set.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    set.add(parent.get(curr));
                }
            }
        }

        // Now q has all nodes at distance k
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.data);
        }

        return list;
    }
}
