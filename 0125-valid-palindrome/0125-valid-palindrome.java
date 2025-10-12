class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while(i < j){
            char left = Character.toLowerCase((s.charAt(i))),
             right = Character.toLowerCase((s.charAt(j)));

            if(!Character.isLetter(left)
             && !Character.isDigit(left)) i++;

            else if(!Character.isLetter(right)
             && !Character.isDigit(right)) j--;

            else if(left == right){
                i++;
                j--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}