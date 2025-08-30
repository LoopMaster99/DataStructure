package Arrays.SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int l = 0, r = 0, len = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(r < n){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if(map.size() > 2){
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
            if(map.size() <= 2)
                len = Math.max(len, r - l + 1); 
            
            r++;
        }

        return len;
    }
}
