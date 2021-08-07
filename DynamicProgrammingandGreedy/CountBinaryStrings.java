package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class CountBinaryStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int oldzeros = 1;
        int oldones = 1;
        for (int i=2;i<=n ;i++ ) {
            int newzeros = oldones;
            int newones = oldones+oldzeros;

            oldones = newones;
            oldzeros = newzeros;
        }
        System.out.println(oldones+oldzeros);
    }
}
