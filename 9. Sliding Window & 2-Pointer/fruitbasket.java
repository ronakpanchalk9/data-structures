import java.util.*;

public class fruitbasket {
    static int totalfruits(int n, int[] fruits) {
        int i = 0;
        int maxCount = 0;

        // Hash Map me only 2 type ke fruit lene hai... unki frequency store krni hai
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < fruits.length; j++) {
            if (!map.containsKey(fruits[j]) && map.size() >= 2) {
                while (map.size() != 1) {
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                    if (map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }
                    i++;
                }
            }
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            maxCount = Math.max((j - i + 1), maxCount);
        }
        
        return maxCount;
    }
}
