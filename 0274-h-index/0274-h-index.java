class Solution {
    public int solve(int[] citations) {
        int n = citations.length;

        int low = 0, high = n - 1, ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;

            int h = (n - mid);
            if(citations[mid] >= h){
                ans = h;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        return solve(citations);
    }
}