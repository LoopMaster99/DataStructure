class Solution {
    int n, m;
    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        int[][] vist = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Node> q = new LinkedList<Node>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.offer(new Node(i,  j, 0));
                    vist[i][j] = 1;
                }
            }
        }

        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Node temp = q.poll();
            
            int row = temp.first;
            int col = temp.second;
            int steps = temp.third;

            dist[row][col] = steps;

            for(int i = 0; i < 4; i++){
                int nrow = row + d_row[i];
                int ncol = col + d_col[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vist[nrow][ncol] == 0){
                    vist[nrow][ncol] = 1;
                    q.offer(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }
}

class Node{
    int first, second, third;

    Node(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}