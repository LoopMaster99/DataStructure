class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i1 = 0;
        int i2 = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            int val = nums[i];
            for(int j = 0; j < n; j++){
                if( j != i){
                    int sum = nums[i] + nums[j];
                    if(sum == target){
                        i1 = i;
                        i2 = j;
                        count++;
                        break;     
                    }
                }
            }
            if(count == 1){
                break;
            }
        }
        int[] arr = new int[]{i1,i2};
        return arr;
    }
}