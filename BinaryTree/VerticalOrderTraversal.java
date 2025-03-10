package BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {
    private static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!q.isEmpty()){
            Tuple tup = q.poll();
            TreeNode node = tup.node;
            int ver = tup.ver, lev = tup.lev;

            if(!map.containsKey(ver)) map.put(ver, new TreeMap<>());

            if(!map.get(ver).containsKey(lev)) map.get(ver).put(lev, new PriorityQueue<>());

            map.get(ver).get(lev).offer(node.data);

            if(node.left != null) q.offer(new Tuple(node.left, ver - 1, lev + 1));
            if(node.right != null) q.offer(new Tuple(node.right, ver + 1, lev + 1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> v: map.values()){
            result.add(new ArrayList<>());

            for(PriorityQueue<Integer> vv: v.values()){
                while(!vv.isEmpty()){
                    result.get(result.size() - 1).add(vv.poll());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};

        BT bt = new BT();
        TreeNode root = bt.buildTree(arr, 0);

        List<List<Integer>> result = verticalTraversal(root);

        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

}

class Tuple{
    TreeNode node;
    int ver, lev;

    Tuple(TreeNode node, int ver, int lev){
        this.node = node;
        this.ver = ver;
        this.lev = lev;
    }
}
