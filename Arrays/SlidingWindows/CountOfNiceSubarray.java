package Arrays.SlidingWindows;

public class CountOfNiceSubarray {
    public int atMost(int[] nums, int k){
        if(k < 0) return 0;

        int n = nums.length;
        int l = 0, r = 0, count = 0, sum = 0;

        while(r < n){
            sum += (nums[r] % 2);

            while(sum > k){
                sum -= (nums[l] % 2);
                l++;
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}
