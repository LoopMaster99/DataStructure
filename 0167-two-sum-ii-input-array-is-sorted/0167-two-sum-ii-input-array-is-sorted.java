class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        int low = 0, high = numbers.length - 1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                res[0] = low + 1;
                res[1] = high + 1;
                break;
            }
            else if(sum < target) low++;
            else high--;
        }

        return res;
    }
}