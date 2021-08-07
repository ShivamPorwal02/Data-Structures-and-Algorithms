package LoveBabbar.Greedy;

public class SmallestNumberwithGivenDigitsandSumofDigits{
    static String smallestNumber(int S, int D) {
        // code here
        StringBuilder s = new StringBuilder();
        if (9 * D < S) return "-1";
        int sum = S - 1; // 1 islia minus kia hai kyuki jo first hai uski range [1,9] honi chahia na
        // [0,9] kyuki 0 sbse aage ni aa skta

        for (int i = 0; i < D; i++) {
            if (sum >= 9) {
                s.append(9);
                sum -= 9;
            } else {
                int c = sum;
                s.append(c);
                sum = 0;
            }
        }

        if (s.length() == D) {
            char s1 = s.charAt(s.length() - 1);

            int n = Integer.parseInt(s1 + "") + 1;

            s.deleteCharAt(s.length() - 1);
            s.append(n);

            return s.reverse().toString();
        }
        s.append(1);
        return s.reverse().toString();
    }
}
