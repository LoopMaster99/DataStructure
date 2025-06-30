package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 *  Problem: Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * You are given two integer arrays:
 *   - inorder[]: inorder traversal of a binary tree
 *   - postorder[]: postorder traversal of the same binary tree
 * 
 * Your task is to construct the original binary tree and return its root.
 * 
 *  Approach:
 * - The last element of the postorder array is always the root of the current subtree.
 * - Use a HashMap to quickly find the root's index in the inorder array.
 * - Elements to the left of the root in inorder are part of the left subtree,
 *   and elements to the right are part of the right subtree.
 * - Recursively build left and right subtrees using correct boundaries.

 *  Time and Space Complexity:
 *         Time: O(N)
 *         Space: O(N)
 */

public class ConstructBinaryTreeFromInPostOrder {
    // Recursive helper to construct tree
    private TreeNode buildTree(int[] post, int postSt, int postEnd,
                               int[] in, int inSt, int inEnd,
                               Map<Integer, Integer> map) {

        // Base case: no nodes to process
        if (postSt > postEnd || inSt > inEnd) return null;

        // The last element in postorder is the root of current subtree
        TreeNode root = new TreeNode(post[postEnd]);

        // Find the root index in inorder array
        int inRoot = map.get(root.data);

        // Number of nodes in the left subtree
        int numLeft = inRoot - inSt;

        // Build left subtree
        root.left = buildTree(post, postSt, postSt + numLeft - 1,
                              in, inSt, inRoot - 1, map);

        // Build right subtree
        root.right = buildTree(post, postSt + numLeft, postEnd - 1,
                               in, inRoot + 1, inEnd, map);

        return root;
    }

    // Main function to start tree construction
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        // Store inorder value → index for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Start recursive construction
        return buildTree(postorder, 0, postorder.length - 1,
                         inorder, 0, inorder.length - 1, map);
    }
}
