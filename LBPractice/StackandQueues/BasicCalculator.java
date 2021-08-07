package LoveBabbar.StackandQueues;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num = 0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                sum+= num*sign;
                i--;
            }else if(s.charAt(i)=='+'){
                sign = 1;
            }else if(s.charAt(i) == '-'){
                sign = -1;
            }else if(s.charAt(i)== '('){
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            }else if(s.charAt(i)==')'){
                int plusminus = st.pop();
                sum = plusminus*sum;
                int num = st.pop();
                sum+=num;
            }
        }
        return sum;
    }
}
