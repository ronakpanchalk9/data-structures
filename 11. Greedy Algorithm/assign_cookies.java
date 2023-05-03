// Assume you are an awesome parent of N children and want to give your children some cookies out of given M cookies. But, you should give each child atmost one cookie.
// Each child i has a greed factor greed [ i ], which is the minimum size of cookie that the child will be content with; and each cookie j has a size sz [ j ]. If sz [ j ] >= greed [ i ], we can assign the cookie j to the child ith, and the child i will be content.
// Your goal is to maximize the number of your content children and return the maximum number.

import java.util.Arrays;

public class assign_cookies {
    static int maxChildren(int n, int m, int greed[], int size[]){
        Arrays.sort(greed);
        Arrays.sort(size);
        int satisfied = 0;
        int j = m-1;
        for (int i = n-1; i >= 0; i--) {
            if(j >= 0 && size[j] >= greed[i]){
                satisfied++;
                j--;
            }
        }
        return satisfied;
    }
}
