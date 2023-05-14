// Given an 2D array intervals of size N representing intervals where intervals [ i ] = [starti , endi ), return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
import java.util.*;

public class nonOverlapping {
    static int minRemoval(int n, int[][] intervals){
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int prevEnd = intervals[0][1];
        int count = 0;
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < prevEnd){
                count++;
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
