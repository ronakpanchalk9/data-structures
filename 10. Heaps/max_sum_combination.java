// Given two integer array A and B of size N each.
// A sum combination is made by adding one element from array A and another element of array B.
// Return the maximum K valid distinct sum combinations from all the possible sum combinations.

// Note : Output array must be sorted in non-increasing order.
import java.util.*;

public class max_sum_combination {
    static List<Integer> maxCombination(int N, int c, int a[], int b[]) {
        List<Integer> al = new ArrayList<Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<String> set = new HashSet<>();

        // first sort the both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        int n = a.length - 1;
        int m = b.length - 1;

        // now we made a PriorityQueue like this -> [sum, (n,m)]
        pq.add(new Pair(a[n] + b[m], n, m)); 
        // here we have a  set also for unique indexes so that no repeated combination is inserted 
        set.add(n + " " + m);

        while (!pq.isEmpty()) {
            // cur will be the value i.e --> [10, (3,3)]
            Pair cur = pq.poll(); 

            // arraylist will add the sum only
            al.add(cur.v);

            if (al.size() == c){
                break;
            }
                
            // x will be index of first array element and y will be the index of second array element
            int x = cur.x;
            int y = cur.y;

            if (x - 1 >= 0 && !set.contains((x - 1) + " " + y)) {
                set.add((x - 1) + " " + y);
                pq.add(new Pair(a[x - 1] + b[y], x - 1, y));
            }

            if (y - 1 >= 0 && !set.contains(x + " " + (y - 1))) {
                set.add(x + " " + (y - 1));
                pq.add(new Pair(a[x] + b[y - 1], x, y - 1));
            }
        }

        return al;
    }

    static class Pair implements Comparable<Pair> {
        int v, x, y;

        Pair(int v, int x, int y) {
            this.v = v;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p) {
            return p.v - this.v;
        }
    }
}