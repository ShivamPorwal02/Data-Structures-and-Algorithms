import java.util.Scanner;

public class PermutationsofString {
    public static int fact(int n){
        int ans = 1;
        for(int i=1;i<=n;i++){
            ans=ans*i;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int n = fact(s.length());
        for (int i=0;i<n ;i++ ) {
            StringBuilder sb = new StringBuilder(s);
            int temp = i;
            for (int j=s.length();j>=1 ;j-- ) {
                int q = temp/j;
                int r = temp%j;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp=q;
            }
            System.out.println();
        }

    }
}
