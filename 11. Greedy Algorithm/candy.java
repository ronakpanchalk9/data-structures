// There are N children standing in a line. Each child is assigned a rating value given in the integer array ratings.
// You are giving candies to these children subjected to the following requirements:

// Each child must have atleast one candy.
// Children with a higher rating get more candies than neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

public class candy {
    static int minCandy(int n, int[] candy) {
        int ans = 0;
        int[] distributed = new int[n];

        for (int i = 0; i < n; i++) {
            distributed[i] = 1;
            for (int j = i; j > 0; j--) {
                if (candy[j - 1] > candy[j] && distributed[j - 1] < candy[j - 1] + 1
                        && distributed[j - 1] <= distributed[j]) {
                    // distributed[j-1] +=1;
                    distributed[j - 1] = distributed[j] + 1;
                } else if (candy[j - 1] < candy[j] && distributed[j - 1] >= distributed[j]
                        && distributed[j] < candy[j] + 1) {
                    // distributed[j] +=1;
                    distributed[j] = distributed[j - 1] + 1;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < distributed.length; i++) {
            ans += distributed[i];
        }
        return ans;
    }
}
