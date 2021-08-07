package LoveBabbar.Strings;

import java.util.Scanner;

public class SplitStringintoSubstringin0s1s {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int ans = 0;
        int num0  = 0;
        int num1 = 0;
        for(int i=0;i<s.length();i++){
            if(Integer.parseInt(s.charAt(i)+"")==1){
                num1+=1;
            }else if(Integer.parseInt(s.charAt(i)+"")==0){
                num0+=1;
            }
            if(num0==num1){
                ans+=1;
                num1 = 0;
                num0 = 0;
            }
        }
        System.out.println(ans);
    }
}
