package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Problem: Binary Tree Inorder Traversal (Morris Traversal)
 * 
 * Given the root of a binary tree, return its inorder traversal **without using recursion or stack**.
 *
 *  Approach: Morris Traversal (Threaded Binary Tree)
 * - We temporarily modify the tree to create threads (right pointers) to predecessors.
 * - This allows us to traverse the tree using O(1) space.
 * - Restore tree structure as we go (undo threading).
 *
 *  Steps:
 * 1. If left child is null, visit current node and go to right.
 * 2. If left child exists, find the rightmost node of the left subtree (predecessor).
 *    - If predecessor’s right is null, thread it to current node and go left.
 *    - If it already points to current, revert the thread, visit node, and go right.
 *
 *  Time and Space Complexity:
 *           Time: O(N)
 *           Space: O(1)
 */

public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // If no left child, visit current and move to right
                list.add(curr.data);
                curr = curr.right;
            } 
            else {
                // Find the inorder predecessor (rightmost node in left subtree)
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    // Create a temporary thread to the current node
                    prev.right = curr;
                    curr = curr.left;
                } 
                else {
                    // Thread exists: revert it, visit current, go to right
                    prev.right = null;
                    list.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return list;
    }
}
