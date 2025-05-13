package BinaryTree;

/*  Diameter of a binary tree —

the longest path between any two nodes (number of edges).
This path can go through or skip the root.

Approach- 

* Go deep into each node’s left and right sides.
* For each node, see how far we can go left + right (that’s one possible path).
* Keep track of the biggest such path in a variable (d[0]).
* Return that max path when done! */

public class DiameterOfTree {
    private int height(TreeNode root, int[] d){
        if(root == null) return 0; // no node = height 0

        int lh = height(root.left, d);  // go left and get height
        int rh = height(root.right, d); // go right and get height

        d[0] = Math.max(d[0], lh + rh); // update diameter if this node gives a longer path

        return 1 + Math.max(lh, rh); // give back height to parent
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1]; // store answer here
        height(root, diameter);      // do all the work in helper
        return diameter[0];          // give the final max path
    }
}
