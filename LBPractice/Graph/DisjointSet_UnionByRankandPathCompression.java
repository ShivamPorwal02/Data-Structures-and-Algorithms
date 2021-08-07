package LoveBabbar.Graph;

import java.util.Scanner;

public class DisjointSet_UnionByRankandPathCompression {
    static int parent[];
    static int rank[];
    public static void main(String[] args) {
        parent = new int[10000];
        rank = new int[10000];
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        while(m>0){
            int u = scn.nextInt();
            int v = scn.nextInt();
            union(u,v);
            m--;
        }
        // if 2 and 3 belongs to same component
        // agr unk parent same hai to they belong to same component
        if(findParent(2)!=findParent(3)) System.out.println("Different Components");
        else System.out.println("Same components");
    }
    public static void makeSet(int n){
        for(int i=1;i<=n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public static int findParent(int node){
        if(node==parent[node]) return node;
        return parent[node] = findParent(parent[node]); // issi step m path compression hora hai
    }
    public static void union(int u,int v){
        u = findParent(u);
        v = findParent(v);

        if(rank[u]>rank[v]){
            parent[v] = u;
        }else if(rank[v]>rank[u]){
            parent[u] = v;
        }else{
            // koi bhi kisika
            parent[u] = v;
            rank[v]++;
        }
    }
}
