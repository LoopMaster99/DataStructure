package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_BFS {
    int rows, cols;
    public void bfs(int r, int c, int[][] image, int newColor, int currColor, Queue<int[]> q){
        image[r][c] = newColor;
        q.offer(new int[]{r, c});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int row = temp[0], col = temp[1];
            
            int[][] adjList = {
                {row - 1, col}, {row + 1, col},
                {row, col - 1}, {row, col + 1}
            };
            
            for(int[] neighbour : adjList){
                int roW = neighbour[0], coL = neighbour[1];
                
                if(roW < 0 || roW >= rows || coL < 0 || coL >= cols
                || image[roW][coL] == newColor || image[roW][coL] != currColor){
                    continue;
                }
                
                image[roW][coL] = newColor;
                q.offer(new int[]{roW, coL});
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        rows = image.length;
        cols = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        bfs(sr, sc, image, newColor, image[sr][sc], q);
        
        return image;
    }
}
