class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int ans = 0;
        int ans_freq = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0)+1);
        }
        for(int i = 0; i < n; i++){
            if(mpp.get(arr[i])<ans_freq){
                ans_freq = mpp.get(arr[i]);
            }
            
        }
        
        for(int i = 0 ; i< n; i++){
            if(mpp.get(arr[i]) == ans_freq && arr[i] > ans){
                ans = arr[i];
            }
        }
        
        return ans;
        
    }
}
