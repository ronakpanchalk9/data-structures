class Solution
{
    public int firstElementKTime(int[] a, int n, int k) { 
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mpp.put(a[i],mpp.getOrDefault(a[i],0)+1);
            if(mpp.get(a[i]) == k){
                return a[i];
            }
        }
        
        return -1;
    } 
}
