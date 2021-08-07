package LoveBabbar.StackandQueues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterinaStream {
    public String FirstNonRepeating(String str)
    {
        // code here
        int[] charCount = new int[26];
        StringBuilder res = new StringBuilder();

        Queue<Character> q = new LinkedList<Character>();

        // traverse whole stream
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            q.add(ch);

            charCount[ch - 'a']++;

            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1)
                    q.remove();
                else {
                    res.append(q.peek());
                    break;
                }
            }
            if (q.isEmpty())
                res.append('#');
        }

        return res.toString();
    }
}
