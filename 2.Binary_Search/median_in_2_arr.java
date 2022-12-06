public class median_in_2_arr {
    static double medianOfArrays(int n, int m, int a[],int b[]){
        //Naive Approach
        
        int[] ans = new int[n+m];
        int pt1 = 0;
        int pt2 = 0;
        int k = 0;
        while(pt1 < n && pt2 < m){
            if(a[pt1]<b[pt2]){
                ans[k] = a[pt1];
                pt1++;
            }else{
                ans[k] = b[pt2];
                pt2++;
            }
            k++;
        }

        while(pt1 < n){
            ans[k] = a[pt1];
            pt1++;
            k++;
        }

        while(pt2 < m){
            ans[k] = b[pt2];
            pt2++;
            k++;
        }
        double median = 0;
        if(ans.length % 2 == 0){
            median = (double)(ans[ans.length / 2] + ans[(ans.length / 2) + 1]) / 2;
        }else{
            median = ans[(ans.length + 1)/2];
        }

        return median;
    }
    public static void main(String[] args) {
        System.out.println((double)(2+2)%2);
        System.out.println((int)Math.ceil((double)(4+5)/2));
        System.out.println((double)(3 + 2)/2);
    }
}
