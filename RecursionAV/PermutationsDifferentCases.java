package RecursionAV;

import java.util.ArrayList;
import java.util.Scanner;

public class PermutationsDifferentCases {
    public static void main(String[] arr){
        ArrayList<String> lst = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        differentCases(input,"",lst);
        System.out.println(lst);
    }
    public static void differentCases(String input,String output,ArrayList<String> lst){
        if(input.length()==0){
            lst.add(output);
            return;
        }
        if((int)input.charAt(0)>65 && (int)input.charAt(0)<122){
                differentCases(input.substring(1),output+(input.charAt(0)+"").toLowerCase(),lst);
                differentCases(input.substring(1),output+(input.charAt(0)+"").toUpperCase(),lst);
        }else {
            differentCases(input.substring(1),output+input.charAt(0),lst);
        }
    }
}
