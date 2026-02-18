class Solution {
    int rows, cols;
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int fresh =  0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;

        int minute = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] temp = q.poll();
                int row = temp[0], col = temp[1];
                int[][] adj = {
                    {row - 1, col},
                    {row + 1, col},
                    {row, col + 1},
                    {row, col - 1}
                };
                for(int[] neighbour : adj){
                    int r = neighbour[0], c = neighbour[1];

                    if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 2 || grid[r][c] == 0) continue;

                    grid[r][c] = 2;
                    q.offer(new int[]{r, c});
                    fresh--;

                    if(fresh == 0) return minute + 1;
                }
            }
            minute++;
        }

        return (fresh == 0) ? minute : -1;
    }    
}