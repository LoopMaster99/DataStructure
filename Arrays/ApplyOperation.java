package Arrays;
import java.util.Arrays;

public class ApplyOperation {
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            if(nums[i] != nums[i + 1]) continue;
            else{
                nums[i] = (nums[i] * 2);
                nums[i + 1] = 0;
            }    
        }

        int x = 0;
        for(int val : nums){
            if(val == 0) continue;
            else nums[x++] = val;
        }
        while(x < n) nums[x++] = 0;

        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 5, 0, 1, 1};
        int[] result = applyOperations(arr);

        System.out.println(Arrays.toString(result));
    }
}
