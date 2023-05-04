// There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
// What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

// Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
import java.util.*;
class Pair implements Comparable<Pair>{
    int start, end;

    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Pair o) {

        return this.end - o.end;
    }

}
public class n_meetings {
    
    static int maxMeetings(int start[], int end[], int n){
        ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Pair(start[i], end[i]));
		}
		
		Collections.sort(list);
		int meetCount = 1;
		int previousMeetEndTime = list.get(0).end;
		for (int i = 1; i < n; i++) {
			if (list.get(i).start > previousMeetEndTime) {
				meetCount++;
				previousMeetEndTime = list.get(i).end;
			}
		}
		return meetCount;
    }

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int n = 6;

        
        System.out.println(maxMeetings(start, end, n));
    }
}
