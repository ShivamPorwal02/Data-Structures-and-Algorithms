package Recursion;

import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        printEncodings(s,"");
    }
    public static void printEncodings(String s,String ans) {
        if(s.length()==0){
            System.out.println(ans);
            return;
        }else if(s.length()==1){
            if(s.charAt(0)=='0'){
                return;
            }
            else{
                int ch = s.charAt(0)-'0';
                char code = (char)('a'+ch-1);
                System.out.println(ans+code);
            }
        }else{
            char x = s.charAt(0);
            String ros = s.substring(1);
            if(x=='0'){
                return;
            }
            else{
                int ch = x-'0';
                char code = (char)('a'+ch-1);
                printEncodings(ros,ans+code);
            }
            String ch12 = s.substring(0,2);
            String roq = s.substring(2);
            if(Integer.parseInt(ch12)<=26){
                char code = (char)('a'+Integer.parseInt(ch12)-1);
                printEncodings(roq,ans+code);
            }

        }

    }

}
