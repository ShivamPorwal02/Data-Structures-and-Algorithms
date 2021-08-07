package RecursionAV;

import java.util.Scanner;

public class PermutationwithSpaces {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String output = "";
        output+=input.charAt(0);
        input = input.substring(1);
        permutationsSpaces(input,output);

    }
    public static void permutationsSpaces(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        permutationsSpaces(input.substring(1),output+"_"+input.charAt(0));
        permutationsSpaces(input.substring(1),output+input.charAt(0));
        return;
    }
}
