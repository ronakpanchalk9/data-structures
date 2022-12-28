import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Given a string S, Find all the possible subsequences of the String in lexicographically-sorted order.
public class power_set {
    public void generate(int idx, List<String> ans, String s, String sub) {
        if (idx == s.length()) {
            ans.add(sub);
            return;
        }
        generate(idx + 1, ans, s, sub + s.charAt(idx));
        generate(idx + 1, ans, s, sub);
        return;
    }

    public List<String> AllPossibleStrings(String s) {
        List<String> finans = new ArrayList<>();
        String sub = "";
        generate(0, finans, s, sub);
        finans.remove("");
        Collections.sort(finans);
        return finans;
    }
}