class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if(n <= 1) return intervals;

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        list.add(new int[]{start, end});

        for(int i = 1; i < n; i++){
            start = intervals[i][0];
            end = intervals[i][1];
            int[] last = list.get(list.size() - 1);
            if(start > last[1]){
                list.add(new int[]{start, end});
            }
            else{
                last[1] = Math.max(last[1], end);
            }                
        }
        
        return list.toArray(new int[list.size()][]);
    }
}