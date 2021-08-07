package LoveBabbar.Strings;

import java.util.HashMap;

public class SecondMostRepeatedString {
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }
        }
        // System.out.println(hm);
        int max1 = 0;
        int max2 = 0;
        String ans = "";
        for(String s : hm.keySet()){
            // System.out.println(s+" "+hm.get(s));
            if(hm.get(s)>max1){
                max2 = max1;
                max1 = hm.get(s);
            }
            else if(hm.get(s)>max2){
                max2 = hm.get(s);
                // ans = s;
            }
            // System.out.println(max2);
        }
        for(String s : hm.keySet()){
            if(max2==hm.get(s)){
                ans = s;
            }
        }
        return ans;
    }
}
