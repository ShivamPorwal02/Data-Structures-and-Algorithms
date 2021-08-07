package LoveBabbar.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumTrainForWhichStoppageCanBeProvided {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int platform = scn.nextInt();
        int trains = scn.nextInt();

        int[][] arr = new int[trains][3];

        for(int i=0;i<trains;i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
            arr[i][2] = scn.nextInt();
        }

        Arrays.sort(arr,(a,b)->(a[1]-b[1]));

        int ans = 0;
        int[] next = new int[platform+1];
        Arrays.fill(next,-1);
        for (int i=0;i < trains;i++ ) {
            if(arr[i][0]>next[arr[i][2]]){
                next[arr[i][2]] = arr[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}
