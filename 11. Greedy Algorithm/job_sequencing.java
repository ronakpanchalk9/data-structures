// Given a set of N jobs where each jobi has a deadline and profit associated with it.

// Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

// Find the number of jobs done and the maximum profit.

// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
public class job_sequencing {
    static int[] jobSequencing(Job[] arr, int n){
        int[] ans = new int[2];
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        int max_ded = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i].deadline > max_ded){
                max_ded = arr[i].deadline;
            }
        }

        int[] temp = new int[max_ded+1];
        
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1;
        }

        int profit = 0;
        int job_cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if(temp[j] == -1){
                    temp[j] = i;
                    profit += arr[i].profit;
                    job_cnt++;
                    break;
                }
            }
        }
        ans[0] = job_cnt;
        ans[1] = profit;

        return ans;
    }
}
