import java.util.Scanner;

public class StringBuilderIntro {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        StringBuilder s = new StringBuilder("Hello");
        StringBuilder s = new StringBuilder(scn.nextLine());
        System.out.println(s);

        char ch = s.charAt(0); // get
        System.out.println(ch);

        s.setCharAt(0,'a'); // set
        System.out.println(s);

        s.insert(2,'e'); //insert
        System.out.println(s);

        s.deleteCharAt(2); // delete
        System.out.println(s);

        s.append("nice");  // append
        System.out.println(s);

    }
}
