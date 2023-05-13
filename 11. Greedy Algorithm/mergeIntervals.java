import java.util.*;

public class mergeIntervals {
    public int[][] overLappedIntervals(int[][] intervals){
        List<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        for (int index = 0; index < intervals.length-1; index++) {
            if(intervals[index][1] < intervals[index+1][0]){
                ans.add(intervals[index]);
            }else if(intervals[index][0] > intervals[index+1][1]){
                ans.add(intervals[index+1]);
            }else {
                intervals[index+1][0] = Math.min(intervals[index][0], intervals[index+1][0]);
                intervals[index+1][1] = Math.max(intervals[index][1], intervals[index+1][1]);
            }
        }
        ans.add(intervals[intervals.length-1]);
        
        return ans.toArray(new int[ans.size()][]);
    }
}
