import java.util.Scanner;

public class TakingInput {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
//         Taking number as a input
//        int n = scn.nextInt();
//        System.out.println(n);
//        // Taking String as a input4
//        String name = scn.nextLine();
//        // Agr akela input lere hai string to ye use krr skte hai
//        System.out.println(name);
//

    // Agr hm chahte hai ki int aur string dono ek saath hi print ho jaaee tbb hme ese krne pdega

        int n  = Integer.parseInt(scn.nextLine());
        String name = scn.nextLine();
        System.out.println(n);
        System.out.println(name);
    }
}
