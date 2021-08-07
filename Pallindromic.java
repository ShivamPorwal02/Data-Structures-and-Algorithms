import java.util.Scanner;

public class Pallindromic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s= "";
        int k=0;
        for(int i=0;i<s2.length();i++){
            for(int j=k;j<s1.length();j++){
                if((int)s1.charAt(j)==(int)s2.charAt(i) || (int)s1.charAt(j)+32==(int)s2.charAt(i) || (int)s1.charAt(j)==(int)s2.charAt(i)+32) {
                    s += s1.charAt(j);
                    k=j+1;
                    break;
                }
                s+=s1.charAt(j);
            }
        }
        System.out.println(s);
    }
//    public static boolean isPl
}
