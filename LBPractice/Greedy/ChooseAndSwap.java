package LoveBabbar.Greedy;

public class ChooseAndSwap {
    String chooseandswap(String s){
        // Code Here
        int[] hash = new int[26];

        for(int i=0;i<26;i++){
            hash[i] = -1;
        }

        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)-'a']==-1) hash[s.charAt(i)-'a'] =i;
        }

        int i =0;
        int j = 0;
        for(i=0;i<s.length();i++){
            boolean flag = false;

            for(j=0;j<s.charAt(i)-'a';j++){
                if(hash[j]>hash[s.charAt(i)-'a']){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        String ans = "";
        if(i<s.length()){
            char ch1 = s.charAt(i);
            char ch2 = (char)(j+'a');

            for(i=0;i<s.length();i++){
                if(s.charAt(i)==ch1){
                    ans+=ch2;
                }else if(s.charAt(i)==ch2){
                    ans+=ch1;
                }else ans+=s.charAt(i);
            }
        }
        return ans==""?s:ans;
    }
}
