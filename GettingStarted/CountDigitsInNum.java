import java.util.Scanner;

public class CountDigitsInNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int cnt=0;
        while(n!=0){
            n=n/10;
            cnt++;
        }
        System.out.println(cnt);
    }
}
