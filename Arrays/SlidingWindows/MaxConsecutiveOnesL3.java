package Arrays.SlidingWindows;

public class MaxConsecutiveOnesL3 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, len = 0, zeros = 0;

        while(r < n){
            if(nums[r] == 0) zeros++;

            while(zeros > k){
                if(nums[l] == 0) zeros--;
                l++;
            }

            if(zeros <= k){
                len = Math.max(len, r - l + 1);
                r++;
            }
        }

        return len;
    }
}
