import java.util.Scanner;

public class StringCompression {
    public static String compression1(String s){
        String s1="";
         s1+= s.charAt(0);
        for (int i=0;i<s.length()-1 ;i++ ) {
            if(s.charAt(i)!=s.charAt(i+1)){
                s1+=s.charAt(i+1);
            }
        }
        return s1;
    }
    public static String compression2(String s){
        String s1="";
        int cnt=1;
        s1+=s.charAt(0);
        for (int i=0;i<s.length()-1;i++ ) {
            System.out.println(cnt);
            if(s.charAt(i)!=s.charAt(i+1)){
                if(cnt!=1) {
                    s1 += cnt;
                }
                s1+=s.charAt(i+1);
                cnt=0;
            }
            cnt++;
        }
        return s1+cnt;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));

    }
}
