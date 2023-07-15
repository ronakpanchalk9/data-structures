// Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
// Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.

import java.util.*;

public class alienDictionary {
    public String findOrder(String[] dict, int N, int K){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = s2.length();
            if(s1.length() < s2.length()){
                len = s1.length();
            }
            for (int j = 0; j < len; j++) {
                if(s2.charAt(j) != s1.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        int[] indegree = new int[K];

        for (int i = 0; i < K; i++) {
            for (int adjacent : adj.get(i)) {
                indegree[adjacent]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }
        String order = "";
        while (!q.isEmpty()) {
            int curr = q.peek();
            q.remove();
            order += (char)(curr + (int)('a'));
            for (int adjacent : adj.get(curr)) {
                indegree[adjacent]--;
                if(indegree[adjacent] == 0){
                    q.add(adjacent);
                }
            }
        }
        return order;
    }
}
