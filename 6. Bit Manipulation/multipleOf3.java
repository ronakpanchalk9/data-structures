class Solution {
    int isDivisible(String s) {
        // code here
        int odd = 0;
        int even = 0;
        
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '1'){
                if(i%2==0){
                    even++;
                }else{
                    odd++;
                }
            }
        }
        if((odd-even)%3==0){
            return 1;
        }
        return 0;
    }
}
