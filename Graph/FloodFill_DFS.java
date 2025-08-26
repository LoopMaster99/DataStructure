package Graph;

public class FloodFill_DFS {
    int rows, cols;
    
    private void dfs(int row, int col, int[][] image, int currColor, int newColor){
        if(row < 0 || row >= rows || col < 0 || col >= cols ||
            image[row][col] != currColor || image[row][col] == newColor){
                return;
        }

        image[row][col] = newColor;
        
        int[][] adjList = {{row - 1, col}, {row, col + 1},
                           {row + 1, col}, {row, col - 1}};

        for(int[] neighbour : adjList){
            dfs(neighbour[0], neighbour[1], image, currColor, newColor);
        }                   
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        dfs(sr, sc, image, image[sr][sc], color);

        return image;
    }
}
