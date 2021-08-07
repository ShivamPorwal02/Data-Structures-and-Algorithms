package LoveBabbar.Strings;

import java.util.PriorityQueue;

public class kthelementinSortedMatrix {
    class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if(k==1){
            return matrix[0][0];
        }
        if(k==matrix.length*matrix.length){
            return matrix[matrix.length-1][matrix.length-1];
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2)->matrix[n1.row][n1.col]-matrix[n2.row][n2.col]);

        for(int i=0;i<matrix.length && i<k;i++){
            minHeap.add(new Node(i,0));
        }

        int cnt =0;
        int result = 0;

        while(!minHeap.isEmpty()){
            Node node = minHeap.remove();
            result = matrix[node.row][node.col];
            if(++cnt==k){
                break;
            }
            node.col++;
            if(matrix[0].length>node.col){
                minHeap.add(node);
            }
        }
        return result;
    }
}
