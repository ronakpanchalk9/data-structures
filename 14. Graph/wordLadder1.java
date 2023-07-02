// Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
// Keep the following conditions in mind:

// A word can only consist of lowercase characters.
// Only one letter can be changed in each transformation.
// Each transformed word must exist in the wordList including the targetWord.
// startWord may or may not be part of the wordList
// The second part of this problem can be found here.

// Note: If no possible way to transform sequence from startWord to targetWord return 0
import java.util.*;

class Pair {
    String word;
    int step;

    Pair(String w, int s) {
        this.word = w;
        this.step = s;
    }
}

public class wordLadder1 {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        /*  BFS se hoga to create a Queue for that, plus ek Set bhi jaha se visited words jo 
            wordList mai hai, wo remove honge
        */
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int len = wordList.length;

        for (int i = 0; i < len; i++) { //saare words daal liye Set mai
            set.add(wordList[i]);     
        }

        q.add(new Pair(startWord, 1)); //initially Queue mai add kardia
        set.remove(startWord);

        while (!q.isEmpty()) {
            String Tempword = q.peek().word;
            int Tempsteps = q.peek().step;
            q.remove();

            if (Tempword.equals(targetWord)) {
                return Tempsteps;
            }

            for (int i = 0; i < Tempword.length(); i++) { //tempWord le lia, jo queue mai tha
                //ab baari baari uske ek ek alphabet ko change karna hai, to see if it exists in the wordList
                for (char ch = 'a'; ch <= 'z'; ch++) { 
                    char[] replacedWordArr = Tempword.toCharArray();
                    replacedWordArr[i] = ch;

                    String newWord = new String(replacedWordArr);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.add(new Pair(newWord, Tempsteps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
