package BinaryTree;

public class BalancedTree {
    // helper to check balance and get depth
    private int depth(TreeNode root) {
        if(root == null) return 0; // empty node = depth 0

        int lh = depth(root.left);  // get left depth
        if(lh == -1) return -1;     // left subtree not balanced, stop early

        int rh = depth(root.right); // get right depth
        if(rh == -1) return -1;     // right subtree not balanced, stop early

        // if positive diff in left & right depth > 1, not balanced
        if(Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh); // return current depth if balanced
    }

    public boolean isBalanced(TreeNode root) {
        // approach: post-order check depth from bottom up
        // if any subtree is unbalanced, return -1 early
        // TC: O(n), visit each node once
        // SC: O(h), recursion stack (h = tree height)
        return depth(root) != -1;
    }
}
