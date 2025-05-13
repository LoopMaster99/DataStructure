package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // to store result

        if(root == null) return list; // if tree is empty, return empty list (edge case)

        Stack<TreeNode> st = new Stack<TreeNode>(); // stack to help with traversal
        st.push(root); // start with root

        while(!st.isEmpty()){ // while stuff is in the stack
            TreeNode node = st.pop(); // take the top node
            list.add(node.data); // save its value

            if(node.left != null) st.push(node.left); // push left child if it exists
            if(node.right != null) st.push(node.right); // push right child if it exists
            // note: right is pushed after left, so left gets popped first
        }

        Collections.reverse(list); // reverse list to get correct postorder

        return list;
    }
}
