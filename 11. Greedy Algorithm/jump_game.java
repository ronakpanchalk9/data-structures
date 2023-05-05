// Given an positive integer N and a list of N integers A[]. Each element in the array denotes the maximum length of jump you can cover. Find out if you can make it to the last index if you start at the first index of the list.
public class jump_game {
    static int canReach(int[] jumps, int N){
        int last = jumps[0];
        int timer = jumps[0];

        for (int i = 0; i < N; i++) {
            if(timer < 0){
                return 0;
            }
            if(jumps[i]+i > last && timer >= 0){
                last = jumps[i]+i;
                timer = jumps[i];
            }
            timer--;
        }
        return 1;
    }
}
