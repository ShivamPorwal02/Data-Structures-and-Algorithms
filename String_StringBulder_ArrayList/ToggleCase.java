import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder s = new StringBuilder(scn.nextLine());
        for (int i=0;i<s.length() ;i++ ) {
            char c = s.charAt(i);
            int ascii  = (int)c;
            if(ascii>=97){
                ascii = ascii-32;
                s.setCharAt(i,(char)ascii);
            }else {
                ascii = ascii+32;
                s.setCharAt(i,(char)ascii);
            }
        }
        System.out.println(s);
    }
}
