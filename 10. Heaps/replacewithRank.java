class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
    int[] dummy=Arrays.copyOf(arr,N);
     Arrays.sort(dummy);
     int rank=1;
     HashMap<Integer,Integer> map=new HashMap<>();
     for(int i:dummy){
         if(!map.containsKey(i)){
             map.put(i,rank);
             rank++;
         }
     }
     for(int j=0;j<N;j++){
         dummy[j]=map.get(arr[j]);
    
     }
     return dummy;
  }
}
