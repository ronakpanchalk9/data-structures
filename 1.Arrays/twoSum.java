class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = arr[i];
            int rem = x - sum;
            if(mpp.containsKey(rem)){
                return true;
            }
            if(!mpp.containsKey(sum)){
                mpp.put(sum, i);
            }
        }
        return false;
    }
}
