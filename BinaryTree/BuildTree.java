package BinaryTree;

import java.util.*;

public class BuildTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // for user input

        int n = scan.nextInt(); // total number of nodes
        int[] nums = new int[n]; // array to store node values

        // fill the array with user input
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        BT tree = new BT(); // create a Binary Tree helper
        TreeNode root = tree.buildTree(nums, 0); // build tree starting from index 0

        // here, you can pass root to any tree function (like traversal etc.)

        scan.close(); // close the scanner
    }
}

class BT {
    // builds tree recursively from array
    public TreeNode buildTree(int[] nums, int idx) {
        // if index goes out of array bounds, return null (no node)
        if (idx >= nums.length) return null;

        // create a new node with value at current index
        TreeNode root = new TreeNode(nums[idx]);

        // recursively build left child at index 2*i + 1
        root.left = buildTree(nums, 2 * idx + 1);

        // recursively build right child at index 2*i + 2
        root.right = buildTree(nums, 2 * idx + 2);

        return root; // return the constructed node
    }
}
