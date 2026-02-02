class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        
        dfs(source, destination, visited, adj);
        if(visited.contains(destination)){
            return true;
        }

        return false;
    }

    private void dfs(int sr, int dest, Set<Integer> visited, List<List<Integer>> adj){
        visited.add(sr);
        if(sr == dest) return;

        for(int neighbour : adj.get(sr)){
            if(!visited.contains(neighbour)){
                dfs(neighbour, dest, visited, adj);
            }
        }
    }
}