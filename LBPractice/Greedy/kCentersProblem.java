package LoveBabbar.Greedy;

import java.util.ArrayList;

public class kCentersProblem {
    public static void main(String[] args)
    {
        int n = 4;
        int[][] weights = new int[][]{ { 0, 4, 8, 5 },
                { 4, 0, 10, 7 },
                { 8, 10, 0, 9 },
                { 5, 7, 9, 0 } };
        int k = 2;

        // Function Call
        selectKcities(n, weights, k);
    }
    public static void selectKcities(int n,int[][] weights,int k){
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        ArrayList<Integer> lst = new ArrayList<>();
        int max = 0;

        for(int i=0;i<k;i++){
            lst.add(max);
            for (int j=0;j<n;j++){
                dist[j] = Math.min(dist[j],weights[max][j]);
            }
            max = maxIndex(dist);
        }
        System.out.println(dist[max]);

        for(int i=0;i<lst.size() ;i++ ) {
            System.out.println(lst.get(i));
        }
    }
    public static int maxIndex(int[] dist){
        int midx = 0 ;
        for(int i=0;i<dist.length;i++){
            if(dist[i]>dist[midx]) midx = i;
        }
        return midx;
    }
}
