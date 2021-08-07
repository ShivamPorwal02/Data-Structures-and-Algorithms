import java.util.Scanner;

public class AllPalindromicSubstrings {
    public static boolean isPalindrome(String s){
        for (int i=0;i<s.length() ;i++ ) {
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        for (int i=0;i<s.length() ;i++ ) {
            for (int j=i+1;j<=s.length() ;j++ ) {
                if(isPalindrome(s.substring(i,j))){
                    System.out.println(s.substring(i,j));
                }
            }
        }

    }
}
