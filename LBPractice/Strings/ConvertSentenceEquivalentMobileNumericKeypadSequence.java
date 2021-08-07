package LoveBabbar.Strings;

import java.util.Scanner;

public class ConvertSentenceEquivalentMobileNumericKeypadSequence {
    public static String count(String[] str,String s){
        String output="";
        for (int i=0;i<s.length();i++ ) {
            if(s.charAt(i)==' '){
                output = output+"0";
            }else{
                output = output + str[s.charAt(i)-'A'];
            }
        }
        return output;

    }

    public static void main(String[] args) {
        String[] str = {
                "2","22","222",
                "3","33","333",
                "4","44","444",
                "5","55","555",
                "6","66","666",
                "7","77","777","7777",
                "8","88","888",
                "9","99","999","9999"
        };
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String ans = count(str,s);
        System.out.println(ans);
    }
}
