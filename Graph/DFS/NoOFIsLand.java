package Graph.DFS;

public class NoOFIsLand {
    int rows, cols;

    private void dfs(int row, int col, char[][] grid, boolean[][] visited){
        if(row < 0 || row >= rows || col < 0 || col >= cols ||
         grid[row][col] == '0' || visited[row][col]){
            return;
        }

        visited[row][col] = true;
        int[][] adjList = {{row - 1, col}, {row, col + 1},
                           {row + 1, col}, {row, col - 1}};

        for(int[] neighbour : adjList){
            dfs(neighbour[0], neighbour[1], grid, visited);
        }
    }

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){

                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }
}
