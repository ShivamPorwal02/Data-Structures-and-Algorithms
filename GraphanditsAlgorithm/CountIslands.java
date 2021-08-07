package GraphanditsAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CountIslands {
    public static void connectedland(int[][] a,int i,int j,boolean[][] visited){
        if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j]==1 || visited[i][j]==true){
            return;
        }


        visited[i][j] = true;
        connectedland(a,i-1,j,visited);
        connectedland(a,i+1,j,visited);
        connectedland(a,i,j-1,visited);
        connectedland(a,i,j+1,visited);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[m][n];

        for (int i = 0; i < a.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        boolean[][] visited = new boolean[a.length][a[0].length];
        int count =0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==0 && visited[i][j]==false){
                    connectedland(a,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);


    }

}
