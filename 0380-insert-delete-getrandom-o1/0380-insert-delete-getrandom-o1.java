import java.util.Random;
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) 
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;    
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int ind1 = map.get(val);
            int ind2 = list.size() - 1;
            int lastVal = list.get(ind2);

            list.set(ind1, list.get(ind2));
            map.put(lastVal, ind1);
            
            list.remove(ind2);
            map.remove(val);
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */