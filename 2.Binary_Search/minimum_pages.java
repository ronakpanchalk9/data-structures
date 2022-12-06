public class minimum_pages {
//     You are given N number of books. Every ith book has Ai number of pages. 
// You have to allocate contiguous books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is the minimum of those in all the other permutations and print this minimum value.

// Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding)

//Optimal Solution Time - O(logN)
    static int findPages(int[] arr, int n, int kids) {
        int low = -1;
        int high = 0;
        int ans = -1;

        for (int i : arr) {
            low = Math.max(low, i);
            high += i;
        }

        if(n == kids){
            return low;
        }

        if(kids > n){
            return -1;
        }

        while(low <= high){
            int mid = (low+high)>>1;

            if(isPossible(arr, mid, kids)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] arr, int mid, int d){
        int student = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum > mid){
                student++;
                sum = arr[i];
            }
        }
        return student <= d;
    }

    public static void main(String[] args) {
        int[] arr = {15,10,19,10,5,18,7};
        System.out.println(findPages(arr, 0, 0));
    }
}
