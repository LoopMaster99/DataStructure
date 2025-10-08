class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int val = nums[i];
            for(int j = 0; j < n; j++){
                if( j != i){
                    if((nums[i] + nums[j]) == target){
                        arr[0] = i;
                        arr[1] = j;
                        count++;
                        return arr;     
                    }
                }
            }
            if(count == 1){
                break;
            }
        }
        return arr;
    }
}