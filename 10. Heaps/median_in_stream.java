
// Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
import java.util.*;

public class median_in_stream {
    public static PriorityQueue<Integer> maxHeap;
    public static PriorityQueue<Integer> minHeap;

    public median_in_stream(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public static void insertHeap(int x) {
        if(maxHeap.size() == 0 || maxHeap.peek() >= x){
            maxHeap.add(x);
        }else{
            minHeap.add(x);
        }
        balanceHeaps();
    }

    // Function to balance heaps.
    public static void balanceHeaps() {
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if (minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    // Function to return Median.
    public static double getMedian()
    {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}