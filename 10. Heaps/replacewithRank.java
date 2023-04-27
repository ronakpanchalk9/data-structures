class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
     PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        HashMap<Integer, Integer> mpp = new HashMap<>();

        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if(!mpp.containsKey(pq.peek())){
                mpp.put(pq.peek(), rank);
                
                rank++;
            }
            pq.remove();
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = mpp.get(arr[i]);
        }

        return arr;
  }
}
