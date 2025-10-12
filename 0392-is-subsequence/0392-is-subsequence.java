class Solution {
    public boolean solve(int i, int j, String s, String t){
        if(i < 0) return true;
        if(j < 0) return false;

        if(s.charAt(i) == t.charAt(j)){
            return solve(i - 1, j - 1, s, t);
        }
        else{
            return solve(i, j - 1, s, t);
        }
    }
    public boolean isSubsequence(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        return solve(i, j, s, t);
    }
}