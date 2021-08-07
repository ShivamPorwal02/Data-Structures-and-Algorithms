package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class CountABCSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int a = 0;
        int ab = 0;
        int abc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a = 2 * a + 1;
            } else if (s.charAt(i) == 'b') {
                ab = 2 * ab + a;
            } else {
                abc = 2 * abc + ab;
            }
        }

        System.out.println(abc);


    }

}
