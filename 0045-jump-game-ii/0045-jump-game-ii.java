class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;

        int count = 0, max = 0, curr = 0, j = 0;
        
        while(j < n){
            max = Math.max(max, j + nums[j]);
            if(max >= n - 1) return count + 1;

            if(j == curr){
                count++;
                curr = max;
            }

            j++;
        }

        return count;
    }
}