package RecursionAV;

import java.util.Scanner;

public class NbitBinaryNumber_1sGreater0s_AllPrefices {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ones = 0;
        int zeros = 0;
        AllPreifx(0,0,"",n);
    }
    public static void AllPreifx(int ones,int zeros,String output,int n){
        if(n==0){
            System.out.println(output);
            return;
        }

        AllPreifx(ones+1,zeros,output+"1",n-1);

        if(ones>zeros){
            AllPreifx(ones,zeros+1,output+"0",n-1);
        }
    }
}
