package LoveBabbar.Greedy;

import java.util.Scanner;

public class MaximumEqualSumsofThreeStacks {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int n3 = scn.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] arr3 = new int[n3];
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for(int i=0;i<n1;i++){
            arr1[i] = scn.nextInt();
            sum1+=arr1[i];
        }

        for(int i=0;i<n2;i++){
            arr2[i] = scn.nextInt();
            sum2+=arr2[i];
        }

        for(int i=0;i<n3;i++){
            arr3[i] = scn.nextInt();
            sum3+=arr3[i];
        }

        int i = 0;
        int j = 0;
        int k = 0;
        boolean flag = true;
        while(i<n1 && j<n2 && k<n3){
            if(sum1==sum2 && sum2==sum3){
                System.out.println(sum1);
                flag=false;
                break;
            }else if(sum1>sum2 && sum1>sum3){
                sum1-=arr1[i];
                i++;
            }else if(sum2>sum1 && sum2>sum3){
                sum2-=arr2[j];
                j++;
            }else if(sum3>sum1 && sum3>sum2){
                sum3-=arr3[k];
                k++;
            }else if(sum1==sum2){
                sum3-=arr3[k];
                k++;
            }else if(sum2==sum3){
                sum1-=arr1[i];
                i++;
            }else if(sum1==sum3){
                sum2-=arr2[j];
                j++;
            }
        }
        if(flag) System.out.println(0);
    }
}
