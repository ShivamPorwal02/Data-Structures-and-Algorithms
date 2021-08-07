package LevelUp.Recursion;
import java.util.Scanner;
public class MaxScore {
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if(idx==words.length){
            return 0;
        }

        int notadded = solution(words,farr,score,idx+1);

        // add krne ka mnn hai but dekhna pdega ki krr bhi skte hai ya ni
        int scoreofthis = 0;
        boolean flag =true ;
        for(int i=0;i<words[idx].length();i++){

            if(farr[words[idx].charAt(i)-'a']==0){
                flag = false;
            }
            farr[words[idx].charAt(i)-'a']--;
            scoreofthis+=score[words[idx].charAt(i)-'a'];
        }

        int scoreyes=0;
        if(flag){
            scoreyes=scoreofthis+solution(words,farr,score,idx+1);
        }

        // wapas aate hue sahi bhi to krna hai

        for(int i=0;i<words[idx].length();i++){
            farr[words[idx].charAt(i)-'a']++;
        }

        return Math.max(scoreyes,notadded);
    }
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));
    }
}
