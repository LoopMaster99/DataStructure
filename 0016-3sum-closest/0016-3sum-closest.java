class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int ans = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n - 2; i++){
            int p1 = i + 1, p2 = n - 1;
            while(p1 < p2){
                int sum = nums[i] + nums[p1] + nums[p2];
                int diff = Math.abs(sum - target);
        
                if(diff == 0) return sum;
                else if(diff < min){
                    min = diff;
                    ans = sum;
                }
                if(sum < target)
                    p1++;
                else if(sum > target) 
                    p2--;      
            }
        }

        return ans;
    }
}