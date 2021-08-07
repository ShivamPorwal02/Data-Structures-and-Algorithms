package LoveBabbar.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        boolean flag = false;
        HashSet<String> hs = new HashSet<>(); // visited array ka sustitute hai yaha
        for(String str : wordList){
            if(str.equals(endWord)) {
                flag = true;
            }
            hs.add(str);
        }

        // we used set kyuki uska remove O(1) m ho jaata hai jbki list ka O(n) leta hai

        if(!flag) return 0;

        int level = 1;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                String str = q.remove();
                if(str.equals(endWord)) return level;
                for(String neigh : neighbours(str,hs)){
                    q.add(neigh);
                }
            }
            level++;
        }
        return 0;
    }
    public List<String> neighbours(String s, HashSet<String> wordList){
        List<String> res = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char [] chars = s.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                chars[i] = ch;
                String word = new String(chars);
                if(wordList.remove(word)){
                    res.add(word);
                    // here removing is like ki hm visited ko true mark krre hai ki yaha koi aur na aae ab
                }
            }
        }
        return res;
    }
}
