package LoveBabbar;

import java.util.Arrays;
import java.util.Scanner;

public class _4_MoveNegativestoLeft {
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        int i = 0;
        int j=arr.length-1;
        while(i<=j){
            if(arr[j]<0 && arr[i]>0){
                swap(arr,i,j);
                i++;
                j--;
            }else if(arr[j]>0){
                j--;
            }else if(arr[j]<0 && arr[i]<0){
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
