package Revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
class Node{
    int data;
    char c;
    Node left;
    Node right;
}
class MyComparator implements Comparator<Node> {
    public int compare(Node x, Node y)
    {
        if(x.data==y.data) return 1;
        return x.data - y.data;
    }
}
public class HuffmanEncoding {
        ArrayList<String> lst;

        public ArrayList<String> huffmanCodes(String s, int f[], int n) {
            // Code here
            lst = new ArrayList<>();
            PriorityQueue<Node> pq = new PriorityQueue<>(n, new MyComparator());

            for (int i = 0; i < n; i++) {
                Node node = new Node();

                node.c = s.charAt(i);
                node.data = f[i];
                node.left = null;
                node.right = null;

                pq.add(node);
            }
            Node root = null;

            while (pq.size() > 1) {
                Node x = pq.poll();
                Node y = pq.poll();

                Node temp = new Node();

                temp.data = x.data + y.data;
                temp.c = '-';
                temp.left = x;
                temp.right = y;
                root = temp;
                pq.add(temp);
            }
            printCode(root, "");
            return lst;
        }

        public void printCode(Node root, String res) {
            if (root.left == null && root.right == null && Character.isLetter(root.c)) {
                lst.add(res);
                return;
            }
            printCode(root.left, res + "0");
            printCode(root.right, res + "1");
            return;
        }
    }
