class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Set<String> set = new HashSet<>();
        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int l1 = strs[i].length();
            if(set.contains(strs[i])) continue;
            else set.add(strs[i]);
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);

            for(int j = i + 1; j < n; j++){
                int l2 = strs[j].length();
                if(l1 != l2) continue;

                int[] map = new int[26];
                boolean flag = true;
                for(char c : strs[i].toCharArray()){
                    map[c - 'a']++;
                }
                for(char c : strs[j].toCharArray()){
                    if(map[c - 'a'] == 0) flag = false;

                    map[c - 'a']--;
                }
                if(!flag) continue;
                set.add(strs[j]);
                temp.add(strs[j]);
            }

            list.add(new ArrayList<>(temp));
        }

        return list;
    }
}