// There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
// Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick to finish all tasks.
// Note: There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all tasks, return an empty array. Returning any correct order will give the output as 1, whereas any invalid order will give the output "No Ordering Possible".
import java.util.*;

public class courseSchedule {
    static int[] findOrder(int n, int m , ArrayList<ArrayList<Integer>> prerequisites){
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int[] finans = new int[n];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            indegree[prerequisites.get(i).get(0)]++;
        }

        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.peek();
            q.remove();
            finans[idx++] = curr;

            for (int i = 0; i < m; i++) {
                if(prerequisites.get(i).get(1) == curr){
                    indegree[prerequisites.get(i).get(0)]--;
                }

                if(indegree[prerequisites.get(i).get(0)] == 0){
                    q.add(prerequisites.get(i).get(0));
                    indegree[prerequisites.get(i).get(0)] = -1;
                }
            }
        }

        return finans;
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int m = 8;
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                int a = sc.nextInt();
                ans.add(a);
            }
            prerequisites.add(ans);
        }

        System.out.println(Arrays.toString(findOrder(n, m, prerequisites)));
    }
}
