import java.util.Scanner;

public class StringwithDiffofConsecutiveChar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String s1="";
        for (int i=0;i<s.length()-1;i++ ) {
            s1+=s.charAt(i);
            int x = (int)s.charAt(i+1)-(int)s.charAt(i);
            s1+=x;
//            s1+=s.charAt(i+1);
        }
        System.out.println(s1+s.charAt(s.length()-1));
    }
}
