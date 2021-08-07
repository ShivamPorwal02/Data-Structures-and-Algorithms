import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp= n/2;
        int str = 1;
        int val=1;
        for (int i = 1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            int cval=val;
            for (int k=1;k<=str ;k++ ) {
                System.out.print(cval+"\t");
                if(k<=str/2){
                    cval++;
                }
                else {
                    cval--;
                }
            }
            if(i<=n/2){
                str+=2;
                sp--;
                val++;
            }
            else{
                sp++;
                str-=2;
                val--;
            }
            System.out.println();
        }

    }
}
