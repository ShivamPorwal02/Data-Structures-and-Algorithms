package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class FriendsPairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int single = 1;
        int pair = 1;
        int total = single+pair;
        for (int i=3;i<=n ;i++ ) {
            int nsingle = total;
            int npair = single*(i-1);
            single = nsingle;
            pair = npair;
            total = single+pair;
        }
        System.out.println(total);
    }
}
