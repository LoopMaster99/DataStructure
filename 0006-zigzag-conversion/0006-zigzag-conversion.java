class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }

        int curr = 0;
        boolean dir = true;
        for(char c : s.toCharArray()){
            sb[curr].append(c);

            if(dir){
                curr++;
                if(curr == numRows - 1) dir = false;
            } 
            else{
                curr--;
                if(curr == 0) dir = true;
            }
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder temp : sb){
            res.append(temp); 
        }

        return res.toString();
    }
}