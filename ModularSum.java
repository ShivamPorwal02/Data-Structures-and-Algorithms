import java.util.Scanner;

public class ModularSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int n = scn.nextInt();
        int d = scn.nextInt();
        int x = scn.nextInt();

        long start = (long)Math.pow(10,n-1);
        long end = (long)Math.pow(10,n);
        int sum = 0;
        for(long i = start;i<end;i++){
            if(i%d==x){
                sum+=i;
            }
        }
        System.out.println((int)(sum%(Math.pow(10,9)+7)));
    }
}
