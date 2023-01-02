// Given a keypad as shown in the diagram, and an N digit number which is represented by array a[ ], the task is to list all words which are possible by pressing these numbers.

import java.util.ArrayList;

public class telephone_prob {
    static void generate(int[] a, int idx, String[] map, ArrayList<String> finans, String s){
        if(idx == a.length-1){
            finans.add(s);
            return;
        }
        
        int num = a[idx];
        String abcd = map[num];
        
        for(int i = 0; i < abcd.length(); i++){
            s += abcd.charAt(i);
            generate(a, idx+1, map, finans, s);
            s = s.substring(0, i) + s.substring(i+1);
        }
        
    }

    static ArrayList<String> possibleWords(int[] a, int N) {
        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> finans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        generate(a, 0, 0, map, finans, temp);
        return finans;
    }
}
