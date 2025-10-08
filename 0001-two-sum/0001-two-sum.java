class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int pivot1 = nums[i];
            int pivot2 = target - pivot1;
            if(map.containsKey(pivot2)){
                arr[0] = map.get(pivot2);
                arr[1] = i;
                return arr;
            }
            map.put(pivot1,i);
        }
        return arr;
    }
}