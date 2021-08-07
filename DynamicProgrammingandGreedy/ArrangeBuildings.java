package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //int n = scn.nextInt();
        int oldB = 1;
        int oldS = 1;
        for (int i = 2; i <= n; i++) {
            int newB = oldS;
            int newS = oldS + oldB;

            oldS = newS;
            oldB = newB;
        }
        System.out.println((oldS + oldB)*(oldB+oldS));
        // square kyukki hrr ek k lia saamne utne hi possible hai
        // jaise 2 k 3 combination possible ha to 1 agr ek side hai to uss ek k lia waha 3 possible hai aese
        // hi 3 ko 3 baar multiply krnehe
    }
}
