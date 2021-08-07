package LoveBabbar.Strings;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrintAllElementsinMatrixSortedRowwiswColumnwise {
    static class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public static ArrayList<Integer> print(int[][] mat){
        ArrayList<Integer> lst = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1,n2)->mat[n1.row][n1.col]-mat[n2.row][n2.col]);
        for(int i=0;i<mat.length;i++){
            minHeap.add(new Node(i,0));
        }
        while (minHeap.size()>0){
            Node node = minHeap.remove();
            int result = mat[node.row][node.col];
            lst.add(result);
            node.col++;
            if(mat[0].length>node.col){
                minHeap.add(node);
            }
        }
        return lst;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                arr[i][j] = scn.nextInt();
            }
        }
        ArrayList<Integer> lst = print(arr);
        System.out.println(lst);
    }

}
