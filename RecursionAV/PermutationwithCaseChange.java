package RecursionAV;

import java.util.Scanner;

public class PermutationwithCaseChange {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        CaseChange(input,"");
    }
    public static void CaseChange(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        CaseChange(input.substring(1),output+input.charAt(0));
        CaseChange(input.substring(1),output+(input.charAt(0)+"").toUpperCase());
    }
}
