class Solution {
    int rows, cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int currColor = image[sr][sc];

        dfs(image, sr, sc, currColor, color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int curr, int color){
        if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != curr || image[row][col] == color) return;

        image[row][col] = color;

        int[][] adjList = {
            {row - 1, col},
            {row, col - 1},
            {row + 1, col},
            {row, col + 1}
        };

        for(int[] neighbour : adjList){
            dfs(image, neighbour[0], neighbour[1], curr, color);
        }
    }
}