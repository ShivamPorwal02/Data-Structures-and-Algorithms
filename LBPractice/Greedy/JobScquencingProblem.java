package LoveBabbar.Greedy;

import java.util.Arrays;

public class JobScquencingProblem {
    class Job{
        int id,profit,deadline;
        Job(int id,int profit,int deadline){
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a, b)->b.profit-a.profit);

        boolean[] isfull = new boolean[101];

        int omax = 0;
        int no = 0;
        int[] ans = new int[2];
        for(int i=0;i<arr.length;i++){
            for(int j = arr[i].deadline-1;j>=0;j--){

                if(isfull[j] == false){
                    isfull[j] = true;
                    omax+=arr[i].profit;
                    no++;
                    break;
                }
            }
        }
        ans[0] = no;
        ans[1] = omax;
        return ans;
    }
}
