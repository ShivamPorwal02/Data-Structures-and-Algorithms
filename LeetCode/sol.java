package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class sol {
    static class Pair{
        int i;
        int j;
        int data;
        int length;
        Pair(int data,int i,int j,int length){
            this.data = data;
            this.i = i;
            this.j =j;
            this.length = length;
        }
    }

    public static void mergeKArrays(int[][] arr,int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i][0], i, 0, arr[i].length));
        }

        ArrayList<Integer> lst = new ArrayList<>();

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            lst.add(rem.data);
            if (rem.j < rem.length - 1) {
                pq.add(new Pair(arr[rem.i][rem.j + 1], rem.i, rem.j + 1, rem.length));
            }
        }
        int i = 0;
        int size = lst.size();
        for (int num : lst) {
            if (i < lst.size() - 1) System.out.print(num + ",");
            else System.out.println(num);
            i++;
        }
    }
}
