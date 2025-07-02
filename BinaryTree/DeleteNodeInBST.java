package BinaryTree;

/**
 *  Problem: Delete Node in a Binary Search Tree
 * 
 * Given the root of a Binary Search Tree (BST) and a key,
 * delete the node with the given key and return the new root.
 *
 *  Approach:
 * ------------------------------------
 * - Traverse the tree to find the node with the given key.
 * - Once found, handle 3 cases:
 *   1. Node has no left child → return right child.
 *   2. Node has no right child → return left child.
 *   3. Node has two children:
 *      - Find the rightmost node of the left subtree.
 *      - Attach the original right subtree to its right.
 *      - Return the modified left subtree as the new subtree root.
 *
 *  Time and Space Complexity:
 * ------------------------------------
 *  Time: O(H)
 *  Space: O(H)
 */

public class DeleteNodeInBST {
    // Helper to find the rightmost node in a subtree
    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null) return root;
        return findLastRight(root.right);
    }

    // Helper to handle deletion and restructuring
    public TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;     // No left child
        if (root.right == null) return root.left;     // No right child

        // Node has two children
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);  // Find rightmost node in left subtree

        lastRight.right = rightChild;  // Attach original right subtree
        return root.left;              // Return modified left subtree
    }

    // Main function to delete a node from BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // If root is the node to delete
        if (root.data == key) return helper(root);

        TreeNode curr = root;

        // Search for the node to delete
        while (curr != null) {
            if (key < curr.data) {
                if (curr.left != null && curr.left.data == key) {
                    curr.left = helper(curr.left);
                    break;
                } 
                else 
                    curr = curr.left;
                
            } 
            else {
                if (curr.right != null && curr.right.data == key) {
                    curr.right = helper(curr.right);
                    break;
                } 
                else 
                    curr = curr.right;
                
            }
        }

        return root;
    }
}
