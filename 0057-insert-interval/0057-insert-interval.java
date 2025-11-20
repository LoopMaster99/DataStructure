class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;

        while(i < intervals.length){
            if(intervals[i][1] < newInterval[0]){
                i++;
            }
            else if(intervals[i][0] > newInterval[1]){
                List<int[]> temp = new ArrayList<>();
                for(int j = 0; j < i; j++){
                    temp.add(intervals[j]);
                }
                temp.add(newInterval);
                for(int j = i; j < intervals.length; j++){
                    temp.add(intervals[j]);
                }

                return temp.toArray(new int[temp.size()][]);
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

                List<int[]> temp = new ArrayList<>();
                for(int j = 0; j < intervals.length; j++){
                    if(j != i){
                        temp.add(intervals[j]);
                    }
                }    

                intervals = temp.toArray(new int[temp.size()][]);
            }
        }

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            res.add(interval);
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}