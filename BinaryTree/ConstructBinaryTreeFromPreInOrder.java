package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * You are given two integer arrays preorder and inorder where:
 *   - preorder is the preorder traversal of a binary tree
 *   - inorder is the inorder traversal of the same tree
 * 
 * Your task is to construct the binary tree and return its root.
 *  
 * Approach:
 * - In preorder traversal, the first element is always the root.
 * - In inorder traversal, the elements to the left of the root are part of the left subtree,
 *   and the elements to the right are part of the right subtree.
 * 
 * Time and Space Complexity:
 *     Time: O(N)
 *     Space: O(N)
 */

public class ConstructBinaryTreeFromPreInOrder {
    // Helper function to build the tree recursively
    private TreeNode buildTree(int[] pre, int preSt, int preEnd,
                               int[] in, int inSt, int inEnd,
                               Map<Integer, Integer> inMap) {
        
        // Base case: if the indices cross, return null (no tree/subtree to build)
        if (preSt > preEnd || inSt > inEnd) return null;

        // First element in current preorder segment is the root
        TreeNode root = new TreeNode(pre[preSt]);

        // Find the root index in inorder array
        int inRoot = inMap.get(root.data);

        // Number of nodes in the left subtree
        int numLeft = inRoot - inSt;

        // Recursively build the left subtree
        root.left = buildTree(pre, preSt + 1, preSt + numLeft,
                              in, inSt, inRoot - 1, inMap);

        // Recursively build the right subtree
        root.right = buildTree(pre, preSt + numLeft + 1, preEnd,
                               in, inRoot + 1, inEnd, inMap);

        // Return the constructed tree root
        return root;
    }

    // Main function to initiate the tree building
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to quickly find the index of any value in inorder array
        Map<Integer, Integer> inMap = new HashMap<>();

        // Fill the map with value → index mappings
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Start recursive tree construction
        return buildTree(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1, inMap);
    }
}
