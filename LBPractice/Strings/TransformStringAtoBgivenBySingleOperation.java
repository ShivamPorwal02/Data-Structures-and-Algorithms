package LoveBabbar.Strings;

import java.util.Scanner;

public class TransformStringAtoBgivenBySingleOperation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        int ans  = transform(s1,s2);
        System.out.println(ans);
    }
    public static int transform(String s1,String s2){
        int i = s2.length()-1;
        int j = s1.length()-1;
        int ans = 0;
        while(i!=0){
            if(s1.charAt(j)==s2.charAt(i)){
                i--;
                j--;
            }else{
                String a = s1.charAt(i)+"";
                String b = s1.substring(0,i);
                String c = s1.substring(i+1);
                s1 = a+b+c;
//                System.out.println(s1);
                ans++;
            }
        }
        return ans;
    }
}
