class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int ran = ransomNote.length();
        int mag = magazine.length();
        if(ran > mag) return false;

        int[] m = new int[26];

        for(char c : magazine.toCharArray()){
            m[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            if(m[c - 'a'] == 0) return false;
            m[c - 'a']--;
        }

        return true;
    }
}