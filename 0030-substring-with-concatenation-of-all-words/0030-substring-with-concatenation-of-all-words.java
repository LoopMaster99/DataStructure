class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();

        List<Integer> result = new ArrayList<>();
        if(s == null || n == 0 || words == null || words.length == 0) return result;

        int wordCount = words.length,
         wordLen = words[0].length(),
         totalLen = wordCount * wordLen;

        if(n < totalLen) return result; 

        Map<String, Integer> need = new HashMap<>();
        for(String word : words){
            need.put(word, need.getOrDefault(word, 0) + 1);
        }

        for(int offSet = 0; offSet < wordLen; offSet++){
            Map<String, Integer> win = new HashMap<>();
            int left = offSet, right = offSet, matched = 0;

            while(right + wordLen <= n){
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if(need.containsKey(word)){
                    win.put(word, win.getOrDefault(word, 0) + 1);

                    if(win.get(word).equals(need.get(word)))
                        matched++;

                    while(win.get(word) > need.get(word)){
                        String leftWord = s.substring(left, left + wordLen);

                        if(win.get(leftWord).equals(need.get(leftWord)))
                            matched--;

                        win.put(leftWord, win.get(leftWord) - 1);
                        left += wordLen;
                    }

                    if(need.size() == matched){
                        result.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        win.put(leftWord, win.get(leftWord) - 1);
                        if(win.get(leftWord) < need.get(leftWord)) matched--;

                        left += wordLen;
                    }
                }
                else{
                    win.clear();
                    matched = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}