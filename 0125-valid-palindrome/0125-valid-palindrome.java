class Solution {
    public boolean isValid(String str){
        int i = 0, j = str.length() - 1;

        while(i < j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }

        return true;
    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == ' ') continue;
            else if(Character.isLetter(ch)  || Character.isDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
            else continue;
        }

        return (isValid(sb.toString())) ? true : false;
    }
}