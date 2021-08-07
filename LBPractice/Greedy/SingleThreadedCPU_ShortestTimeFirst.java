package LoveBabbar.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU_ShortestTimeFirst {
    public class Task{
        int startTime;
        int processTime;
        int index;

        Task(int startTime,int processTime,int index){
            this.startTime=startTime;
            this.processTime=processTime;
            this.index=index;
        }
    }
    public class Duration implements Comparator<Task> {
        @Override
        public int compare(Task one,Task two){
            if(one.processTime==two.processTime) return one.index-two.index;
            return one.processTime-two.processTime;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];

        Task[] extTasks = new Task[n];

        for(int i=0;i<n;i++){
            extTasks[i] = new Task(tasks[i][0],tasks[i][1],i);
        }
        Arrays.sort(extTasks,(one, two)->one.startTime-two.startTime);

        int ai = 0;  // answer index
        int ti = 0; // task index

        int currentTime = 0;

        PriorityQueue<Task> pq=new PriorityQueue<>(new Duration());

        while(ai<n){
            while(ti<n && extTasks[ti].startTime<=currentTime){
                pq.add(extTasks[ti]);
                ti++;
            }
            if(pq.size()==0){
                currentTime = extTasks[ti].startTime;
                continue;
            }
            Task bestFit=pq.remove();
            ans[ai]=bestFit.index;
            currentTime+=bestFit.processTime;
            ai++;
        }
        return ans;
    }
}
