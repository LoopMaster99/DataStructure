package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {
    int rows, cols;

    private void bfs(int s_row, int s_col, char[][] grid,
     Queue<int[]> q, boolean[][] visited){

        visited[s_row][s_col] = true;
        q.offer(new int[]{s_row, s_col});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int row = temp[0], col = temp[1];

            int[][] adjList = {{row - 1, col}, {row, col + 1},
                               {row + 1, col}, {row, col - 1}};

            for(int[] neighbour : adjList){
                int r = neighbour[0];
                int c = neighbour[1];

                if(r < 0 || r >= rows || c < 0 || c >= cols ||
                   grid[r][c] == '0' || visited[r][c]){
                    continue;
                }

                visited[r][c] = true;
                q.offer(new int[]{r, c});
            }
        }
    }
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int isLands = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(i, j, grid, q, visited);
                    isLands++;
                }
            }
        }

        return isLands;
    }
}
