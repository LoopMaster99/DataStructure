class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;

        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            if(map[c - 'a'] <= 0) return false;
            map[c - 'a']--;
        }
        
        return true;
    }
}