package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TupleSameProduct {

    public static int tupleSameProduct(int[] nums) {
            Arrays.sort(nums);
    
            int n = nums.length, tup = 0, result = 0;
            Map<Integer, Integer> map = new HashMap<>();
    
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
    
                    int product = nums[i] * nums[j];
                    map.put(product , map.getOrDefault(product, 0) + 1);
    
                }
            }
    
            for(Map.Entry<Integer, Integer> it: map.entrySet()){
    
                if(it.getValue() > 1){
                    int freq = it.getValue();
                    tup = freq * (freq - 1)/2;
    
                    result += tup;
                }
                
            }
    
            return result * 8;
        }
    
        public static void main(String[] args) {
            int[] nums = {2,3,4,6};
            int result = tupleSameProduct(nums);

            System.out.println(result);
    }
}
