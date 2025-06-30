package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {

/**
 *  Problem: Serialize and Deserialize Binary Tree
 * 
 * You are to implement two functions:
 * 1. serialize(TreeNode root): Converts a binary tree into a string.
 * 2. deserialize(String data): Converts the encoded string back into the original binary tree.
 *
 *  Approach:
 * 🔸 For **serialization**:
 * - Use **level-order traversal (BFS)**.
 * - Append node values to a string, and use a special marker (e.g., #) for null nodes.
 * 
 * 🔸 For **deserialization**:
 * - Split the string and use a queue to build the tree in level order.
 * - For each node, assign left and right children by reading the next two values.
 * 
 *  Time and Space Complexity:
 *      Time: O(N)
 *      Space: O(N)
 */


    // Serializes a binary tree to a string using level-order traversal
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp == null) {
                sb.append("# ");
                continue;
            }

            sb.append(temp.data).append(" ");
            q.offer(temp.left);
            q.offer(temp.right);
        }

        return sb.toString();
    }

    // Deserializes a string back to the binary tree structure
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < str.length; i++) {
            TreeNode node = q.poll();

            // Process left child
            if (!str[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                node.left = left;
                q.offer(left);
            }

            // Process right child
            if (++i < str.length && !str[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                node.right = right;
                q.offer(right);
            }
        }

        return root;
    }

}
