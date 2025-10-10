class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int len = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while(j < n){
            sum += nums[j];

            while(sum >= target){
                len = Math.min(len, j - i + 1);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return (len != Integer.MAX_VALUE) ? len : 0;
    }
}