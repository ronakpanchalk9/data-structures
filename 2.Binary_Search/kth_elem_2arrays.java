public class kth_elem_2arrays {
//*Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array.*/

    public static int binarySearch(int[] arr, int low, int high, int k){
        if(high < low){
            return -1;
        }
        if(high < k){
            return high;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid == k){
                return mid;
            }else if(mid < k){
                low = mid+1;
            }else if(mid > k){
                high = mid-1;
            }           
        }
        
        return low;
    }

    public static long kthElement(int[] arr1, int[] arr2, int n, int m, int k){
        if(n > m){
            return kthElement(arr2, arr1, m, n, k);
        }

        int low = Math.max(0, k-m);
        int high = Math.min(k, n);
        int l1 = 0;
        int l2 = 0;
        int r1 = 0;
        int r2 = 0;

        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = k - mid1;

            if(mid1 == 0){
                l1 = Integer.MIN_VALUE;
            }else{
                l1 = arr1[mid1-1];
            }

            if(mid2 == 0){
                l2 = Integer.MIN_VALUE;
            }else{
                l2 = arr2[mid2-1];
            }

            if(mid1 == n){
                r1 = Integer.MAX_VALUE;
            }else{
                r1 = arr1[mid1];
            }

            if(mid2 == m){
                r2 = Integer.MAX_VALUE;
            }else{
                r2 = arr2[mid2];
            }
            
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            } 
            

        }
        return -1;

        // int mid1 = binarySearch(arr1, 0, n-1, k);
        // int mid2 = binarySearch(arr2, 0, m-1, k);
        // int ans = 0;
        // int i = 0;
        // int j = 0;
        // while(i <= mid1 && j <= mid2 && (i+j) < k){
        //     if(arr1[i] <= arr2[j]){
        //         ans = arr1[i];
        //         i++;
        //     }else{
        //         ans = arr2[j];
        //         j++;
        //     }
        // }

        // while(i <= mid1 && (i+j) < k){
        //     ans = arr1[i];
        //     i++;
        // }

        // while(j <= mid2 && (i+j) < k){
        //     ans = arr2[j];
        //     j++;
        // }
        // return ans;
    }
    public static void main(String[] args) {
        // int[] a1 = {1,2,2,4,5,6,9,11,11,12,20,20,25,25,26,29,30,30,31,34,35,36,36,37,41,41,43,43,44,45,45,46,47,47,47,48,49,49,50,51,52,52,52,54,56,56,56,56,57,57,57,59,60,61,62,64,65,65,67,68,68,69,71,72,73,74,76,76,81,82,83,86,87,89,91,91,91,92,94,95,95,96,97,97,98};
        // int[] a2 = {9,53,59,87};
        // int k = 19;
        // int[] a1 = {2,3,6,7,9};
        // int[] a2 = {1,4,8,10};
        // int k = 9;
        // System.out.println(kthElement(a1, a2, a1.length, a2.length, k));
        System.out.println(-652 >> 2);
        System.out.println(16 >> 0);
    }
}
