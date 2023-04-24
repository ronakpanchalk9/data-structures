// Given an array of N positive integers, print k largest elements from the array. 
public class k_largest{
    static void heapify(int arr[], int n, int i){
        int l = 2*i+1;
        int r = 2*i+2;
        int greatest = i;
        
        if(l < n && arr[l] > arr[greatest]){
            greatest = l;
        }
        if(r < n && arr[r] > arr[greatest]){
            greatest = r;
        }
        if(i != greatest){
            swap(i,greatest,arr);
            heapify(arr,n,greatest);
        }
    }
    static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        for(int i = n/2; i >= 0; i--){
            heapify(arr,n,i);
        } 
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1; i >= 0; i--){
            swap(0,i,arr);
            heapify(arr,i,0);
        }
        int end = n-1;
        while(k != 0){
            ans.add(arr[end]);
            k--;
            end--;
        }
        return ans;
    }
}