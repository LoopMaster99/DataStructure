class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> path = new HashSet<>();
        boolean[] visited = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        
        dfs(source, visited, path, adj);
        if(path.contains(destination)){
            return true;
        }

        return false;
    }

    private void dfs(int sr, boolean[] visited, Set<Integer> path, List<List<Integer>> adj){
        path.add(sr);
        visited[sr] = true;

        for(int neighbour : adj.get(sr)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, path, adj);
            }
        }
    }
}