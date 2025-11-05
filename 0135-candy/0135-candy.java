class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1) return 1;
        
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        //left pass
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                candy[i] = Math.max(candy[i], candy[i - 1] + 1);
            }
        }

        //right pass
        for(int j = n - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1]){
                candy[j] = Math.max(candy[j], candy[j + 1] + 1);
            }
        }

        int count = 0;
        for(int val : candy){
            count += val;
        }

        return count;
    }
}