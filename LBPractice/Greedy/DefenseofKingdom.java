package LoveBabbar.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DefenseofKingdom {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
            int n = scn.nextInt();
            int m = scn.nextInt();
            int tower = scn.nextInt();
            if(tower==0) {
                System.out.print(n*m);
                continue;
            }
            int[] arr1 = new int[tower];
            int[] arr2 = new int[tower];
            for(int i=0;i<tower;i++){
                arr1[i]= scn.nextInt();
                arr2[i] = scn.nextInt();
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int maxX = arr1[0]-1;
            int maxY = arr2[0]-1;

            for(int i=1;i<tower;i++){
                maxX = Math.max(maxX,arr1[i]-arr1[i-1]-1);
                maxY = Math.max(maxY,arr2[i]-arr2[i-1]-1);
            }

            maxX = Math.max(maxX,n-arr1[tower-1]);
            maxY = Math.max(maxY,m-arr2[tower-1]);
            // yaha prr -1 islia n kia ha kyuki last wale m ni hai if to dekho soch k ki 15-11 4 hi khali rhnge na ki 3
            System.out.println(maxX*maxY);
            t--;
        }
    }
}
