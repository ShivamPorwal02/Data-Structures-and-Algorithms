package LevelUp.Recursion;
import java.util.Scanner;
public class GoldMine2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j  < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
    }
    public static int getSum(int[][] arr,int i,int j,boolean[][] visited){
//        System.out.println(i+" "+j);
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0 || visited[i][j]==true){
            return 0;
        }
        visited[i][j] = true;
//         System.out.println(i+" "+j);
        int top = getSum(arr,i-1,j,visited);
        int left = getSum(arr,i,j-1,visited);
        int right = getSum(arr,i,j+1,visited);
        int down = getSum(arr,i+1,j,visited);
        return top+left+right+down+arr[i][j];

    }
    static int max = 0;
    public static void getMaxGold(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0 && visited[i][j]==false) {
                    int sum = getSum(arr, i, j,visited);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
    }

}
