public class nth_root{
    static int nthRoot(int power, int num){
        int low = 0;
        int high = num;

        while(low <= high){
            int mid = (low + high) >> 1;
            if(Math.pow(mid, power) == num){
                return mid;
            }else if(Math.pow(mid,power) > num){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }
}