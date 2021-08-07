package RecursionAV;

import java.util.Scanner;

public class PrintSubsetsofString {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        subsets(input,"");

    }
    public static void subsets(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        subsets(input.substring(1),output); // iss baar ni lere
        subsets(input.substring(1),output+input.charAt(0));
        return;

    }
}
