class Solution {
// Print GFG n times without the loop.
    void printGfg(int N) {
        if(N < 1){
            return;
        }
        System.out.print("GFG ");
        printGfg(N-1);
        
    }
}
