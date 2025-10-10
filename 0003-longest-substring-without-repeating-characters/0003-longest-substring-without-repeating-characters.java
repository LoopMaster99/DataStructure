class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int i = 0, j = 0, len = 0;
        while(j < n){
            char ch = s.charAt(j);

            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(ch);
            len = Math.max(len, j - i + 1);
            j++;
        }

        return len;
    }
}