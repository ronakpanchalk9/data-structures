class Solution
{
   
    String reverseEqn(String S)
    {   
        Stack<String> st = new Stack<>();
        int l=S.length();
        for(int i=0;i<l;i++){
            if((int)S.charAt(i)>=48 && (int)S.charAt(i)<=57){
                 String snew= new String();
                 while(i!=l && (int)S.charAt(i)>=48 && (int)S.charAt(i)<=57){
                     snew += S.charAt(i);
                     i++;
                 }
                 i--;
                 st.push(snew);
            }
            else st.push(String.valueOf(S.charAt(i)));
        }
        
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        
        return sb.toString();
    }
}
