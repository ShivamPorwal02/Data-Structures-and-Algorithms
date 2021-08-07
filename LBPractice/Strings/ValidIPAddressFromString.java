package LoveBabbar.Strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddressFromString {
    public List<String> restoreIpAddresses(String s) {

        List<String> lst = new ArrayList<>();
        for(int a=1;a<=3;a++){
            for(int b = 1;b<=3;b++){
                for(int c = 1;c<=3;c++){
                    for(int d = 1;d<=3;d++){
                        if(a+b+c+d==s.length()){
                            int A = Integer.parseInt(s.substring(0,a));
                            int B = Integer.parseInt(s.substring(a,a+b));
                            int C = Integer.parseInt(s.substring(a+b,a+b+c));
                            int D = Integer.parseInt(s.substring(a+b+c));
                            if(A<=255 && B<=255 && C<=255 && D<=255){
                                if((A+"."+B+"."+C+"."+D).length()==s.length()+3){
                                    lst.add(A+"."+B+"."+C+"."+D);
                                }
                            }
//                            yaha prr last wala if islia lgaya hai kyuki ho skta hai ki 01 ho value aur vo 1 ho
//                            jaae to a+b+c+d == s.length to rhnge lekin last m vo Integer.parseInt krne prr 1
//                            krdega islia hmne last m vo waali condition bhi check krli

                        }
                    }
                }
            }
        }
        return lst;
    }
}
