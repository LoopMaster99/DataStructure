package BinaryTree;

/*  Height of a tree: Number of edges on the longest path from the root to any leaf.
   Note - to return the number of edges you should subtract 1 at the end.
*/

public class HeightOfTree {
    int height(TreeNode node) {
        if (node == null) return -1; // no node = -1 height (no edges)

        int lh = height(node.left);  // go left and get height
        int rh = height(node.right); // go right and get height

        return 1 + Math.max(lh, rh); // add 1 (for edge down) + max of both sides
    }

}
