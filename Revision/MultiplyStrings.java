package Revision;

public class MultiplyStrings {
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        if(s1.equals("0") || s2.equals("0")) return "0";
        int ans = 1;
        if(s1.charAt(0)=='-' || s2.charAt(0)=='-') ans = -1;
        if(s1.charAt(0)=='-' && s2.charAt(0)=='-') ans = 1;

        if(s1.charAt(0)=='-') s1 = s1.substring(1);
        if(s2.charAt(0)=='-') s2 = s2.substring(1);
        // System.out.println(s1)
        int l1 = s1.length();
        int l2 = s2.length();

        int[] res = new int[l1+l2];
        int pf = 0;
        int i = l2-1;
        while(i>=0){
            int ival = s2.charAt(i)-'0';
            int carry = 0;
            int j = l1-1;
            int k = res.length-1-pf;
            while(j>=0 || carry!=0){
                int jval =  j>=0 ? s1.charAt(j)-'0' : 0;
                int prod = ival*jval + carry+res[k];
                res[k] = prod%10;
                carry = prod/10;
                k--;
                j--;
            }
            i--;
            pf++;
        }
        // System.out.println(Arrays.toString(res));
        StringBuilder s = new StringBuilder();
        boolean flag = false;
        for(i=0;i<res.length;i++){
            if(res[i]==0 && flag == false){
                continue;
            }else{
                flag = true;
                s.append(res[i]);
            }
        }
        if(ans==-1){
            return "-"+s.toString();
        }
        return s.toString();
    }
}
