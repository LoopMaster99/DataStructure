package BinaryTree;

import java.util.*;

public class Right_Left_SideView {

    // Right View Helper Function
    public void r_view(TreeNode root, List<Integer> list, int level){
        if(root == null) return; // no node to process

        // Only add first node seen at this level
        if(level == list.size()){
            list.add(root.data); // save it
            
            // Go right first so rightmost is chosen first
            r_view(root.right, list, level + 1);
            r_view(root.left, list, level + 1);
        }
    }

    // Left View Helper Function
    public void l_view(TreeNode root, List<Integer> list, int level){
        if(root == null) return;

        if(level == list.size()){
            list.add(root.data);
            
            // Go left first so leftmost is chosen first
            l_view(root.left, list, level + 1);
            l_view(root.right, list, level + 1);
        }
    }

    // Right Side View Function
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        r_view(root, list, 0); // start at level 0
        return list;
    }

    // Left Side View Function
    public List<Integer> leftSideView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        l_view(root, list, 0); // start at level 0
        return list;
    }

}

