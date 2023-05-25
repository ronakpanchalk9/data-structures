class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort1(int arr[], int low, int high)
    {
        // code here
        if(low < high){
            int pIndex = partition(arr, low, high);
            quickSort1(arr, low, pIndex-1);
            quickSort1(arr,pIndex+1, high);
        }
    }
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        
        quickSort1(arr,0,arr.length-1);
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        while(i < j){
            while(arr[i] <= pivot && i <= high-1){
                i++;
            }
            while(arr[j] > pivot && j >= low+1){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
                
        }
        int temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;
        
        return j;
    } 
}
