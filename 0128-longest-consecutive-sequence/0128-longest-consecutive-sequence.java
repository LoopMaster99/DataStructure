class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int maxCount = 0;
        for(int num : set){

            if(!set.contains(num - 1)){
                int count = 1;
                int curr = num;
                while(set.contains(curr + 1)){
                    count++;
                    curr++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}