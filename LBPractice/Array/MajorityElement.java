package LoveBabbar;

import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n ;i++ ) {
            nums[i] = scn.nextInt();
        }

        int cnt = 0;
        int canditate = 0;

        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                canditate = nums[i];
            }
            if(canditate==nums[i]){
                cnt++;
            }else{
                cnt--;
            }
            // kyuki n/2 se jyda hoga islia hmne just cancel krte rhe last m ek bchega wahi ans hoga
        }
        System.out.println(canditate);
    }

}
