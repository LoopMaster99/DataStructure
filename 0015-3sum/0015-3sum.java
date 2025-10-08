class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int p1 = i + 1, p2 = n - 1;
            while(p1 < p2){
                int sum = nums[i] + nums[p1] + nums[p2];

                if(sum == 0){
                    list.add(Arrays.asList(
                        nums[i], nums[p1], nums[p2])
                        );    
                        p1++;
                        p2--;

                        while(p1 < p2 && nums[p1] == nums[p1 - 1])
                            p1++;
                        while(p1 < p2 && nums[p2] == nums[p2 + 1])
                            p2--;
                }
                else if(sum < 0)
                    p1++;
                
                else if(sum > 0) 
                    p2--;      
            }
        }

        return list;
    }
}