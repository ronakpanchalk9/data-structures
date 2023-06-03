class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        int  beg = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == s){
                ans.add(beg+1);
                ans.add(i+1);
                break;
            }else if(sum > s){
                while(sum > s && beg < i){
                    sum -= arr[beg];
                    beg++;
                }
                if(sum == s){
                ans.add(beg+1);
                ans.add(i+1);
                break;
                }
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;
    }
}
