package LoveBabbar.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    class Solution {
        HashMap<Integer,Node> hm;
        public Node cloneGraph(Node node) {
            hm = new HashMap<>();

            return neighbour(node);

        }
        public Node neighbour(Node node){
            if(node==null) return null;
            if(hm.containsKey(node.val)) return hm.get(node.val);
            Node copy = new Node(node.val);
            hm.put(node.val,copy);

            for(Node n : node.neighbors){
                copy.neighbors.add((neighbour(n)));
            }

            return copy;
        }
    }
}
