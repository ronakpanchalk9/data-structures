import java.util.*;

public class combination_sum {
    static void generate(ArrayList<ArrayList<Integer>> finans, ArrayList<Integer> temp, ArrayList<Integer> a, int idx,
            int target) {
        if (idx == a.size()) {
            if (target == 0) {
                finans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (target >= a.get(idx)) {
            temp.add(a.get(idx));
            generate(finans, temp, a, idx, target - a.get(idx));
            temp.remove(a.get(idx));
        }
        generate(finans, temp, a, idx + 1, target);
    }

    static ArrayList<ArrayList<Integer>> combination(ArrayList<Integer> a, int b) {
        Set<Integer> set = new HashSet<>(a);
        ArrayList<Integer> set_a = new ArrayList<>(set);
        Collections.sort(set_a);
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> finans = new ArrayList<>();
        generate(finans, temp, set_a, 0, b);
        return finans;
    }
}
