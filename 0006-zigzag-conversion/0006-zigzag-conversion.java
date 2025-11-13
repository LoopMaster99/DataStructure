class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        Map<Integer, List<Character>> map = new HashMap<>();

        int curr = 0;
        boolean dir = true;
        for(int i = 0; i < s.length(); i++){
            map.computeIfAbsent(curr, k -> new ArrayList<>()).add(s.charAt(i));
            if(dir){
                curr++;
                if(curr == numRows - 1) dir = false;
            } 
            else{
                curr--;
                if(curr == 0) dir = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            if(map.containsKey(i)){
                List<Character> list = map.get(i);
                for(char c : list)
                    sb.append(c);
            }    
        }

        return sb.toString();
    }
}