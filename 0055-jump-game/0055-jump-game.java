class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0, j = 0;

        while(j < n){
            if(j > max) return false;

            max = Math.max(max, j + nums[j]);
            j++;

            if(max >= n - 1) return true;
        }

        return true;
    }
}