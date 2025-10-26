class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String value : strs){
            char[] ch = value.toCharArray();
            Arrays.sort(ch);

            String key = String.valueOf(ch);
            map.computeIfAbsent(key,
             k -> new ArrayList<>()).add(value);
        }

        list.addAll(map.values());

        return list;
    }
}