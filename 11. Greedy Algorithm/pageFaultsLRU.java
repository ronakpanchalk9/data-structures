// In operating systems that use paging for memory management, page replacement algorithm is needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page.

// Given a sequence of pages in an array pages[] of length N and memory capacity C, find the number of page faults using Least Recently Used (LRU) Algorithm. 
import java.util.*;

public class pageFaultsLRU {
    static int pageFaults(int N, int C, int pages[]) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (q.contains(pages[i])) {
                q.remove(pages[i]);
                q.add(pages[i]);
            }else {
                count += 1;
                q.add(pages[i]);

                if (q.size() > C){
                    q.poll();
                }
            }
        }

        return count;
    }
}
