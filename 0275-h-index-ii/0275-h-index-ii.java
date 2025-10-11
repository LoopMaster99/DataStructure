class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int low = 0, high = n - 1, ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;

            int len = (n - mid);
            if(citations[mid] >= len){
                ans = Math.max(ans, len);
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }
}