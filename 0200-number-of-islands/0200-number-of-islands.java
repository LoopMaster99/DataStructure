class Solution {
    int rows, cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int islands = 0;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(i, j, grid, visited, q);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] visited, Queue<int[]> q) {
        visited[row][col] = true;
        q.offer(new int[] { row, col });

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int sr = temp[0], sc = temp[1];

            int[][] adj = {
                    { sr - 1, sc },
                    { sr + 1, sc },
                    { sr, sc - 1 },
                    { sr, sc + 1 }
            };

            for (int[] neighbour : adj) {
                int r = neighbour[0], c = neighbour[1];

                if (r < 0 || c < 0 || r >= rows || c >= cols ||
                        visited[r][c] || grid[r][c] == '0')
                    continue;

                visited[r][c] = true;
                q.offer(new int[]{r, c});
            }
        }
    }
}