class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;

        if(n == 0) return res;

        int ind = 0;
        while(true){
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            int len = 0, count = 0;
            while(ind < n){
                int wordLen = words[ind].length();
                if(wordLen + len + count <= maxWidth){
                    list.add(words[ind]);

                    len += wordLen;
                    count += 1;
                }
                else break;

                ind++;
            }
            if(ind >= n){    
                if (list.size() == 0) break;

                String sp = String.join(" ", list);
                int left = maxWidth - sp.length();
                sb.append(sp);
                while(left-- > 0) sb.append(" ");
                res.add(sb.toString());

                break;
            }

            int gap = count - 1;
            int rem = maxWidth - len;
            if(gap == 0){
                sb.append(list.get(0));
                while(rem-- > 0) sb.append(" ");
            }
            else{
                int perGap = rem / gap;
                int extra = rem % gap;

                for(int i = 0; i < list.size(); i++){
                    sb.append(list.get(i));

                    if(i != list.size() - 1){
                        int spaces = perGap + (extra > 0 ? 1 : 0);
                        extra--;

                        while(spaces-- > 0) sb.append(" ");
                    }
                }
            }
            res.add(sb.toString());
        }

        return res;
    }
}