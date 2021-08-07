package LevelUp.Recursion;

public class Swapstirng {
    public static void main(String[] args) {
        String str = "Shivam";
        char chx = str.charAt(0);

        str.replace(str.charAt(0),str.charAt(1));
        str.replace(str.charAt(1),chx);
        System.out.println(str);
    }
}
