// Given a string S and an integer K. In one operation, you are allowed to choose any character of the string and change it to any other uppercase English character.You can perform this operation atmost K times.
// Return the length of the longest substring containing same letter you can get after performing the above operations.
// Note : S consists of only uppercase English letters.
public class longest_char_repeat {
    static int characterReplacement(String s, int k) {
        int begin = 0;
        int max_len = 0;
        int max_count = 0;
        int n = s.length();
        int[] alphabets = new int[26];

        for (int end = 0; end < n; end++) {
            alphabets[s.charAt(end) - 'A'] = +1;
            int current_char_count = alphabets[s.charAt(end) - 'A'];
            max_count = Math.max(max_count, current_char_count);

            while (end - begin - max_count + 1 > k) {
                alphabets[s.charAt(begin) - 'A'] = -1;
                begin++;
            }
            max_len = Math.max(max_len, end - begin + 1);
        }

        return max_len;
    }
}
