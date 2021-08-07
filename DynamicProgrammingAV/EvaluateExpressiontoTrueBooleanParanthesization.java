package DynamicProgrammingAV;

import java.util.HashMap;
import java.util.Scanner;

public class EvaluateExpressiontoTrueBooleanParanthesization {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int ans = evaluateExpressiontoTrue(s,0,s.length()-1,true);
        System.out.println(ans);

        mp.clear();// just ese hi;
        int ans2 = evaluateExpressionMemo(s,0,s.length()-1,true);
        System.out.println(ans2);
    }
    public static int evaluateExpressiontoTrue(String s,int i,int j,boolean isTrue){
        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue==true){
                return s.charAt(i)=='T'?1:0;
            }else{
                return s.charAt(i)=='F'?1:0;
            }
        }
        int ans = 0;
        for (int k=i+1;k<=j-1 ;k=k+2 ) {
            int leftT = evaluateExpressiontoTrue(s,i,k-1,true);
            int leftF = evaluateExpressiontoTrue(s,i,k-1,false);
            int rightT = evaluateExpressiontoTrue(s,k+1,j,true);
            int rightF = evaluateExpressiontoTrue(s,k+1,j,false);

            if(s.charAt(k)=='^'){
                if(isTrue==true){
                    ans+=leftT*rightF+leftF*rightT;
                }else{
                    ans+=leftF*leftF+rightT*leftT;
                }
            }else if(s.charAt(k)=='&'){
                if(isTrue==true){
                    ans+=leftT*rightT;
                }else{
                    ans+=leftT*rightF+rightT*leftF+leftF*rightF;
                }
            }else{
                if(isTrue==true){
                    ans+=leftT*rightF+rightT*leftF+leftF*rightF;
                }else{
                    ans+=leftT*rightT;
                }
            }
        }
        return ans;
    }
    // MEMORIZATION(BOTTOM UP)
    static HashMap<String,Integer> mp = new HashMap<>();
    public static int evaluateExpressionMemo(String s,int i,int j,boolean isTrue){
        if(i>j){
            return 0;
        }
        int ans = 0;
        if(i==j){
            if(isTrue){
                return s.charAt(i)=='T'?1:0;
            }else{
                return s.charAt(i)=='F'?1:0;
            }
        }
        String temp = i+" "+j+" "+isTrue;
        if(mp.containsKey(temp)){
            return mp.get(temp);
        }
        for (int k=i+1;k<=j-1;k=k+2){
            int leftT = evaluateExpressionMemo(s,i,k-1,true);
            int leftF = evaluateExpressionMemo(s,i,k-1,false);
            int rightT = evaluateExpressionMemo(s,k+1,j,true);
            int rightF = evaluateExpressionMemo(s,k+1,j,false);
            if(s.charAt(k)=='^'){
                if(isTrue==true){
                    ans+=leftT*rightF+leftF*rightT;
                }else{
                    ans+=leftF*leftF+rightT*leftT;
                }
            }else if(s.charAt(k)=='&'){
                if(isTrue==true){
                    ans+=leftT*rightT;
                }else{
                    ans+=leftT*rightF+rightT*leftF+leftF*rightF;
                }
            }else{
                if(isTrue==true){
                    ans+=leftT*rightF+rightT*leftF+leftF*rightF;
                }else{
                    ans+=leftT*rightT;
                }
            }
        }
        mp.put((i+" "+j+" "+isTrue),ans);
        return ans;
    }
}
