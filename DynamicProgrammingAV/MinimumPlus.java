package DynamicProgrammingAV;

import java.util.Scanner;

public class MinimumPlus {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        int ans = minimumPlus(s1,s2,0,s1.length()-1);
        System.out.println(ans);
    }
    public static int minimumPlus(String s1,String s2,int i,int j){
        if(i>j){
            return 0;
        }
        if(Integer.parseInt(s1)==Integer.parseInt(s2)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i+1;k<=j-1;k=k+2){
            int tempans = minimumPlus(s1,s2,i,k)+minimumPlus(s1,s2,k+1,j)+1;
//            int right = minimumPlus(s1,s2,k+1,j);
            if(tempans<min){
                min = tempans;
            }
        }
        return min;
    }
}
