class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curr = 0, total = 0, j = 0, start = 0;
        
        while(j < n){
            int diff = gas[j] - cost[j];
            curr += diff;
            total += diff;

            if(curr < 0){
                curr = 0;
                start = j + 1;
            } 
            j++;
        }
        return (total >= 0) ? start : -1;
    }
}