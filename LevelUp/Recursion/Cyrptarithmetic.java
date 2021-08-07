package LevelUp.Recursion;
import java.util.*;
public class Cyrptarithmetic {
    public static void main(String[] ar) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();

        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    }

    public static int getNum(HashMap<Character, Integer> charIntMap, String s) {
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            num += charIntMap.get(s.charAt(i));
        }
        return Integer.parseInt(num);
    }

    public static void solution(String unique, int idx,
                                HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
                                String s1, String s2, String s3) {
        // write your code here

        if (idx == unique.length()) {
            int num1 = getNum(charIntMap, s1);
            int num2 = getNum(charIntMap, s2);
            int num3 = getNum(charIntMap, s3);

            if (num1 + num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('a' + i);
                    if (charIntMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        char ch = unique.charAt(idx);

        for (int i = 0; i <= 9; i++) {
            if (usedNumbers[i] == false) {
                charIntMap.put(ch, i);
                usedNumbers[i] = true;
                solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                charIntMap.put(ch, -1);
                usedNumbers[i] = false;
            }
        }
    }
}
