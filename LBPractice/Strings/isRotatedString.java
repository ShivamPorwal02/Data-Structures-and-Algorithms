package LoveBabbar.Strings;

public class isRotatedString {
    public boolean rotateString(String A, String B) {
        return A.length()==B.length() && (A+A).indexOf(B)!=-1;
    }

}
