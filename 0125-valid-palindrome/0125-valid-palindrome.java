class Solution {
    public boolean isPalindrome(String s) {
        String copy = s.toLowerCase();
        int i = 0, j = s.length() - 1;

        while(i < j){
            char left = copy.charAt(i), right = copy.charAt(j);

            if(left == ' ') i++;
            else if(right == ' ') j--;
            else if(!Character.isLetter(left) && !Character.isDigit(left)) i++;
            else if(!Character.isLetter(right) && !Character.isDigit(right)) j--;
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