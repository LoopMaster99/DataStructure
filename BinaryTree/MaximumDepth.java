package BinaryTree;

/* Max Depth of a tree: The maximum depth of a binary tree is the length
 of the longest path from the root node down to a leaf. */

public class MaximumDepth {
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0; // no node = depth 0

        int lh = maxDepth(root.left);  // check depth on left
        int rh = maxDepth(root.right); // check depth on right

        return 1 + Math.max(lh, rh); // add 1 for this node and take bigger side
    }
}
