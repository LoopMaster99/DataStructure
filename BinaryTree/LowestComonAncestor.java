package BinaryTree;

        /* LCA: you need to find the lowest node in the tree that has both n1 and n2 as its descendants (where a node can be a descendant of itself).
           So basically, we have to find lowest node in the tree where both nodes
             can be found beneath it (or it is one of them) */ 

public class LowestComonAncestor {
    TreeNode lca(TreeNode root, int p, int q) {
        // If tree is empty or we find one of the target nodes, return it
        if(root == null || root.data == p || root.data == q) return root;
        
        // Search for the nodes in the left subtree
        TreeNode left = lca(root.left, p, q);
        
        // Search for the nodes in the right subtree
        TreeNode right = lca(root.right, p, q);
        
        // If one node found in left and one in right, this node is the LCA(boss)
        if(left != null && right != null) return root;
        
        // Else return the non-null child (either left or right)
        return (left != null) ? left : right;
    }

}
