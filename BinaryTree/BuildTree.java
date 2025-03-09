package BinaryTree;

import java.util.*;

public class BuildTree {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);

        int n = scan.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }

        BT tree = new BT();
        TreeNode root = tree.buildTree(nums, n);
        
        // now pass root in any function

        scan.close();
    }
}

class BT{
    public TreeNode buildTree(int[] nums, int idx){
        if(idx >= nums.length) return null;

        TreeNode root = new TreeNode(nums[idx]);

        root.left = buildTree(nums, 2 * idx + 1);
        root.right = buildTree(nums, 2 * idx + 2);
        
        return root;
    }
}
