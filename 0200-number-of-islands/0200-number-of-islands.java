class Solution {
    int rows, cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int noOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }

    private void dfs(int sr, int sc, char[][] grid, boolean[][] visited) {
        if (sr < 0 || sr >= rows || sc < 0 || sc >= cols ||
                grid[sr][sc] == '0' || visited[sr][sc])
            return;

        visited[sr][sc] = true;

        int[][] adjList = {
                { sr - 1, sc },
                { sr + 1, sc },
                { sr, sc - 1 },
                { sr, sc + 1 }
        };

        for (int[] neighbour : adjList) {
            dfs(neighbour[0], neighbour[1], grid, visited);
        }
    }
}