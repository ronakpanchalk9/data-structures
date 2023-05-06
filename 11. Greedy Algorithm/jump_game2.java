// Given an array of N integers arr[] where each element represents the maximum length of the jump that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
// Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.

// Note: Return -1 if you can't reach the end of the array.

public class jump_game2{
    static int minJumps(int arr[], int n){
        int total_steps = 1;
        int range = arr[0];
        int steps_left = arr[0];
        
        
        if(arr[0] == 0){
            return -1;
        }
        if(arr.length == 0){
            return 0;
        }

        for (int i = 1; i < arr.length; i++) {
            if(i == n-1){
                return total_steps;
            }
            if(arr[i] + i > range){
                range = arr[i]+i;
            }
            steps_left--;
            if(steps_left == 0){
                if(range <= i){
                    return -1;
                }
                steps_left = range - i;
                total_steps++;
            }
            
        }
        return -1;
    }
}