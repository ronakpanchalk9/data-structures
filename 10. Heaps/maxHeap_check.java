// Given an array A of size N, the task is to check if the given array represents a Binary Max Heap.
public class maxHeap_check {
    public boolean countSub(long arr[], long n)
    {
        boolean ans = true;
        int i = 0;
        while(i < n){
            int l = 2*i+1;
            int r = 2*i+2;
            if((l < n && arr[l] > arr[i]) || (r < n && arr[r] > arr[i])){
                ans = false;
            }
            i++;
        }
        return ans;
    }
}
