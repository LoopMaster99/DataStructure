class Solution {
    public int romanToInt(String s) {
        int n = s.length();

        int index = 0, val1 = 0, val2 = 0;
        char c1 = ' ', c2 = ' ';
        int total = 0;

        while(index < n){
            c1 = s.charAt(index);
            val1 = getChar(c1);

            if(index + 1 < n){
                c2 = s.charAt(index + 1);
                val2 = getChar(c2);

                if(val1 < val2){
                    total += val2 - val1;
                    index += 2;
                    continue;
                }
            }

            total += val1;
            index += 1;
        }

        return total;
    }

    private int getChar(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}