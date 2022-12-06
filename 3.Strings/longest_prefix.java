// Given a array of N strings, find the longest common prefix among all strings present in the array.

public class longest_prefix {
    static String longestPrefix(String[] arr, int n) {
        int min = Integer.MAX_VALUE;
        String ans = null;
        int minStringIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
                minStringIdx = i;
            }
        }
        int i = 0;
        while (i < n && min >= 0) {
            if (arr[i].startsWith(arr[minStringIdx].substring(0, min))) {
                ans = arr[minStringIdx].substring(0, min);
                i++;
                continue;
            } else {
                i = 0;
                min--;
            }
        }
        if (ans.length() == 0) {
            ans = "-1";
        }
        return ans;
    }
}
