package BinaryTree;

public class MaximumPathSum {
    // helper to get max gain from each node and update max path sum
    private int height(TreeNode root, int[] maxi) {
        if(root == null) return 0; // no node = no gain

        // go left and right, ignore negative paths
        int lh = Math.max(0, height(root.left, maxi));
        int rh = Math.max(0, height(root.right, maxi));

        // check if current path through this node is best so far
        maxi[0] = Math.max(maxi[0], lh + rh + root.data);

        // return max path if we continue upward (only one side allowed)- fetching max branch
        return root.data + Math.max(lh, rh);
    }

    public int maxPathSum(TreeNode root) {
        int[] maxi = {Integer.MIN_VALUE}; // store max path sum found
        height(root, maxi); // do the work
        return maxi[0]; // final answer
    }
}
