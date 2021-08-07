package LoveBabbar.Strings;

public class MinimumNumberofFlips {
    public int minFlips(String s) {
        // Code here
        // when first number is 1
        int min1 = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0 && s.charAt(i)!='1'){
                min1++;
            }
            if(i%2!=0 && s.charAt(i)!='0'){
                min1++;
            }
        }

        // when first number is 0
        int min2 = 0;
        for(int i=0;i<s.length();i++){
            if(i%2!=0 && s.charAt(i)!='1'){
                min2++;
            }
            if(i%2==0 && s.charAt(i)!='0'){
                min2++;
            }
        }
        return min1>min2 ? min2 : min1;
    }
}
