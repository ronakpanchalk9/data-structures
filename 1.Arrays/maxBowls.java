// There are N bowls containing cookies. In one operation, you can take one cookie from any of the non-empty bowls and put it into another bowl. If the bowl becomes empty you discard it. You can perform the above operation any number of times. You want to know the maximum number of bowls you can have with an identical number of cookies.

// Note: All the non-discarded bowls should contain the identical number of cookies.
class Solution {
    public static int getMaximum(int N, int[] arr) {
        // code here
        long sum = 0;
        for(int i = 0; i< arr.length; i++){
            sum += arr[i];
        }

        while(N >1){
            if(sum % N == 0){
                return N;
            }
            N= N-1;
        }
        return N;
    }
}
