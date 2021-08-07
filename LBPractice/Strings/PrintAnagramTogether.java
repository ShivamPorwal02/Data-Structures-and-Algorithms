package LoveBabbar.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintAnagramTogether {
    public List<List<String>> Anagrams(String[] str) {

        // my method
        List<List<String>> lst = new ArrayList<>();
        List<String> lst1 = new ArrayList<>();
        lst1.add(str[0]);
        lst.add(lst1);
        for (int i = 1; i < str.length; i++) {
            String s = str[i];
            int len = lst.size();
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                String checker = lst.get(j).get(0);
                if (isAnagram(s, checker)) {
                    lst.get(j).add(s);
                    flag = true;
                    break;
                }
            }
            if (flag != true) {
                List<String> lst2 = new ArrayList<>();
                lst2.add(s);
                lst.add(lst2);
            }
        }
        return lst;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (hm.containsKey(s2.charAt(i))) {
                int x = hm.get(s2.charAt(i)) - 1;
                if (x == 0) {
                    hm.remove(s2.charAt(i));
                } else {
                    hm.put(s2.charAt(i), x);
                }
            } else {
                return false;
            }
        }
        return hm.size() == 0;
    }
}
