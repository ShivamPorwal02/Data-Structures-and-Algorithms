package RecursionAV;

import java.util.*;

public class PrintUniqueSubsets {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        HashSet<String> hs = new HashSet<>();
        uniqueSubsets(input,"",hs);
        System.out.println(hs);
        // if you are asked to print the string in lexicographical order
        List<String> lst = new ArrayList<>(hs);
        Collections.sort(lst);
        System.out.println(lst);
    }
    public static void uniqueSubsets(String input,String output,HashSet<String> hs){
        if(input.length()==0){
            hs.add(output);
            return;
        }
        uniqueSubsets(input.substring(1),output,hs);
        uniqueSubsets(input.substring(1),output+input.charAt(0),hs);
        return;
    }
}
