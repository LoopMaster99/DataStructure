class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, formed = 0, len = Integer.MAX_VALUE;
        Map<Character, Integer> win = new HashMap<>();

        int start = 0;
        while(right < s.length()){
            char c1 = s.charAt(right);

            if(need.containsKey(c1)){
                win.put(c1, win.getOrDefault(c1, 0) + 1);
                if(need.get(c1).intValue() == win.get(c1).intValue())
                    formed++;
            }

            while(need.size() == formed){
                if(right - left + 1 < len){
                    start = left;
                    len = right - left + 1;
                }

                char c2 = s.charAt(left);
                if(need.containsKey(c2)){
                    win.put(c2, win.get(c2) - 1);
                    if(win.get(c2) < need.get(c2))
                        formed--;

                }
                left++;    
            }

            right++;
        }    

        return (len != Integer.MAX_VALUE) ? s.substring(start, start + len) : "";
    }
}