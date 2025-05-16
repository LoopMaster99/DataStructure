package BinaryTree;
import java.util.*;

public class BoundaryTraversal {
    /*  Print the boundary of the binary tree in anticlockwise direction:
        * Root
        * Left boundary (excluding leaves)
        * All leaf nodes (left to right)
        * Right boundary (excluding leaves, printed in reverse)
    */

    // Go left as far as possible, add non-leaf nodes.
    void leftBoundary(TreeNode node, ArrayList<Integer> list) {
        TreeNode curr = node.left;
        while(curr != null) {
            if(!isLeaf(curr)) list.add(curr.data); // skip leaves
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    // Do a DFS and add only the leaf nodes.
    void addLeaf(TreeNode node, ArrayList<Integer> list) {
        if(isLeaf(node)) {
            list.add(node.data);
            return;
        }
        if(node.left != null) addLeaf(node.left, list);
        if(node.right != null) addLeaf(node.right, list);
    }

    /* Go right as far as possible, add non-leaf nodes to a
    temporary list, then reverse and add to final list. */
    void rightBoundary(TreeNode node, ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = node.right;
        while(curr != null) {
            if(!isLeaf(curr)) res.add(curr.data); // skip leaves
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        // Add in reverse order
        for(int i = res.size() - 1; i >= 0; i--) {
            list.add(res.get(i));
        }
    }

    // Check if node is a leaf
    boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    // Main boundary traversal
    ArrayList<Integer> boundaryTraversal(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(!isLeaf(node)) ans.add(node.data); // root (only if not a leaf)

        leftBoundary(node, ans); // left side
        addLeaf(node, ans);      // leaf nodes
        rightBoundary(node, ans); // right side

        return ans;
    }

}
