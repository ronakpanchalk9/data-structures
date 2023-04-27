// Given a character array tasks of size N, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
// However, there is a non-negative integer K that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be atleast K units of time between any two same tasks.
// Return the least number of units of times that the CPU will take to finish all the given tasks.

import java.util.*;

public class taskScheduler {
    static int leastInterval(int N, int K, char tasks[]) {

        Map<Character, Integer> task_counter = new HashMap<>();

        for (Character task : tasks) {
            task_counter.put(task, task_counter.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(task_counter.values());

        int time = 0;

        while (pq.size() > 0) {
            List<Integer> add_back = new ArrayList<>();


            for (int i = 0; i <= K; i++) {
                if (pq.size() > 0) {
                    int count = pq.poll();
                    count--;
                    if (count > 0) {
                        add_back.add(count);
                    }
                }
                time += 1;
                if (pq.size() == 0 && add_back.size() == 0) {
                    break;
                }
            }

            pq.addAll(add_back);
        }

        return time;
    }
}
