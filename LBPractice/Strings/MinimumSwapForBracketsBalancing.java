package LoveBabbar.Strings;

import java.util.ArrayList;

public class MinimumSwapForBracketsBalancing {
    static int minimumNumberOfSwaps(String s) {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                lst.add(i);
            }
        }

        char ch[] = s.toCharArray();
        int p = 0;
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == '[') {
                p++;
                cnt++;
            } else if (ch[i] == ']') {
                cnt--;
                if (cnt < 0) {
                    ans += lst.get(p) - i;
                    char temp = ch[i];
                    ch[i] = ch[lst.get(p)];
                    ch[lst.get(p)] = temp;
                    p++;
                    cnt = 1;
                }
            }
        }
        return ans;
    }
}
