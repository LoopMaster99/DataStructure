package Greedy;

public class MinimumEqualSumAfterReplacingZero {
    public long minSum(int[] nums1, int[] nums2) {
        // Initialize sums and zero counters
        long sum1 = 0, sum2 = 0, cnt1 = 0, cnt2 = 0;

        // Calculate sum and count of zeros in nums1
        for (int x : nums1) {
            sum1 += x;
            if (x == 0) cnt1++;
        }

        // Calculate sum and count of zeros in nums2
        for (int y : nums2) {
            sum2 += y;
            if (y == 0) cnt2++;
        }

        // Calculate possible minimum total by replacing 0s with 1s
        long min1 = sum1 + cnt1;
        long min2 = sum2 + cnt2;

        // If no zeros in both arrays, sums must be equal
        if (cnt1 == 0 && cnt2 == 0) {
            return (sum1 == sum2) ? sum1 : -1;
        }
        // If nums2 has no zeros, check if nums1 can reach or exceed sum2
        else if (cnt2 == 0) {
            return (min1 <= sum2) ? sum2 : -1;
        }
        // If nums1 has no zeros, check if nums2 can reach or exceed sum1
        else if (cnt1 == 0) {
            return (min2 <= sum1) ? sum1 : -1;
        }

        // Both arrays have zeros — return the larger of the two possible minimum sums
        return Math.max(min1, min2);
    }
}

