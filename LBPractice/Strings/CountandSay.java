package LoveBabbar.Strings;

public class CountandSay {
    public String countAndSay(int n) {

        String s = "1";
        for(int i=0;i<n-1;i++){
            char c = s.charAt(0);
            StringBuilder sb = new StringBuilder(); //used bcauz jyda efficient hai
            int cnt = 1;
            for(int j=1;j<s.length();j++){
                //checking consecutive same
                if(s.charAt(j)!=c){
                    sb.append(cnt);
                    sb.append(c);
                    cnt = 0;
                    c = s.charAt(j);
                }
                cnt++;
            }
            sb.append(cnt);
            sb.append(c);
            s = sb.toString();

        }
        return s;
    }
}
