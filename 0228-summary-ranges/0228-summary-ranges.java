class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;

        if(n == 0) return list;

        int start = 0, end = 0;
        while(end < n){
            while(end < n - 1 && nums[end] + 1 == nums[end + 1]){
                end++;
            }

            if(nums[start] == nums[end]){
                list.add(String.valueOf(nums[end]));
            }
            else{
                String str = nums[start] + "->" + nums[end];
                list.add(str);
            }

            end++;
            start = end;
        }

        return list;
    }
}