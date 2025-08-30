package Arrays.SlidingWindows;

public class BinarySubArrayWithSum {
    public int atMost(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int l = 0, r = 0, count = 0, sum = 0;

        while(r < n){
            sum += nums[r];

            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            
            count += r - l + 1;
            r++;
        }

        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
}
