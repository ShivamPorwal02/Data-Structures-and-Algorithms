import java.util.Scanner;

public class StringIntro {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = "hello";
//        String s2 = scn.nextLine(); // this would  take the whole line as the input
//        String s3 = scn.next(); // this would take the input until the space is found
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
        System.out.println(s1.length()); // length string m fn hai aur array m data member
        s1.charAt(0);
        for (int i=0;i<s1.length() ;i++ ) {
            System.out.println(s1.charAt(i));
        }
//        s1.charAt(0)='z'; // wont work

        // Substring
        System.out.println(s1.substring(1,3)); // last wala is not included
        System.out.println(s1.substring(1)); // agr kevl begin index doge to end tkk aaega

        String s ="abcd";
        // printing all the substrings
        for (int i=0;i<s.length();i++ ) {
            for (int j=i+1;j<=s.length() ;j++ ) {
                System.out.println(s.substring(i,j));
            }
        }

        // Concatination of strings

        s+=' ';
        s+='s';
        s+=10;
        String s2 = "World";
        String s3 = s+" "+s2;
        System.out.println(s3);
        System.out.println(10+20+"hello"); // left to right evaluate hota hai islia 30hello
        System.out.println("hello"+10+20);  // similar reason


        // Splits

        s = "abc def ghi gh";
        String[] parts = s.split(" "); // splits returns a array
        for (int i =0;i<parts.length ;i++ ) {
            System.out.println(parts[i]);
        }
    }
}
