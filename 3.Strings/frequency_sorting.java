import java.util.*;


public class frequency_sorting {
    static void freq(List<Integer> list) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            hm.put(list.get(i), hm.getOrDefault(list.get(i), 0) + 1);
        }

        Collections.sort(list, (n1, n2) -> {
            int freq1 = hm.get(n1);
            int freq2 = hm.get(n2);

            if (freq1 != freq2) {
                return freq2 - freq1;
            }

            return n1 - n2;
        });

        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            ArrayList<Integer> l1 = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                l1.add(sc.nextInt());
            }

            for (int j = 0; j < len; j++) {
                System.out.print(l1.get(i)+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}