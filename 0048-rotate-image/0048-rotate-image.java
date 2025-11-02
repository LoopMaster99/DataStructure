class Solution {
    public void reverse(int[] arr){
        int i = 0, j = arr.length - 1;

        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
    public void swap(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < m; j++){
                swap(matrix, i, j);
            }
        }

        for(int[] rev : matrix){
            reverse(rev);
        }
    }
}