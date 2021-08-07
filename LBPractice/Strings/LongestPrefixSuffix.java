package LoveBabbar.Strings;

public class LongestPrefixSuffix {
    public String longestPrefix(String s) {

        int lps[] = new int[s.length()];
        lps[0] = 0;
        int i=1;
        int j=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else{
                if(j!=0){
                    j = lps[j-1];  // agr same ni hota hai to hm wha prr jaate hai jaha pr
                                    // yaha prr current j hai usk ek piche aur ussp jo hota hai uss index se aafe
                                    // compare hoga
                                    // See VIDEO
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0,lps[s.length()-1]);
    }
}
