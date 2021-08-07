import java.util.Scanner;

public class FindElementInArray {
    public static int FindIndex(int[] a,int key){
        for (int i=0;i<a.length ;i++ ) {
            if(a[i]==key){
                return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int key = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<a.length ;i++ ) {
            a[i]=scn.nextInt();
        }
        int index= FindIndex(a,key);
        System.out.println(index);
    }
}
