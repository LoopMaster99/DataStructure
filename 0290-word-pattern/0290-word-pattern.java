class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        
        if(pattern.length() != str.length) return false;

        Map<String, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < str.length; i++){
            String ss = str[i];
            char cc = pattern.charAt(i);

            if(!Objects.equals(map1.get(ss), map2.get(cc))) return false;

            map1.put(ss, i);
            map2.put(cc, i);
        }

        return true;
    }
}