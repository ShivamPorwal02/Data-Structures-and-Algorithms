package LoveBabbar.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WaterandJug_BFS {

    // At any state (a,b) of the jugs we can do 6 things.
    //     1.Pour contents of jug1 to jug2. (note that jug1 may still have some water left after pouring water to jug2)
    //     2.Pour contents of jug2 to jug1. (note that jug2 may still have some water left after pouring water to jug1)
    //     3.Empty jug1 completely.
    //     4.Empty jug2 completely.
    //     5.Fill jug1 completely (to its maximum limit)
    //     6.Fill jug2 completely (to its maximum limit)


    class State{
        int x;
        int y;
        State(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if(jug1+jug2==target) return true;
        if(jug1+jug2<target) return false;
        // we cant fill odd amnt of water in both even container
        if(jug1%2==0 && jug2%2==0 && target%2!=0) return false;

        HashSet<String> visited = new HashSet<>();
        Queue<State> q = new LinkedList<>();

        q.add(new State(0,0));

        // using bfs

        while(q.size()>0){
            State rem = q.remove();
            if(rem.x+rem.y==target || rem.x==target || rem.y==target){
                System.out.println(rem.x+" "+rem.y);
                return true;
            }
            visited.add(rem.x+","+rem.y);

            int newx,newy;
            // state 1
            newx = rem.x - Math.min(rem.x,jug2-rem.y);
            newy = rem.y+ Math.min(rem.x,jug2-rem.y);
            if(visited.contains(newx+","+newy)==false) q.add(new State(newx,newy));

            // state 2
            newx = rem.x + Math.min(jug1-rem.x,rem.y);
            newy = rem.y - Math.min(jug1-rem.x,rem.y);
            if(visited.contains(newx+","+newy)==false) q.add(new State(newx,newy));

            //state 3
            newx = 0;
            newy = rem.y;
            if(visited.contains(newx+","+newy)==false) q.add(new State(newx,newy));

            // state 4
            newx = rem.x;
            newy = 0;
            if(visited.contains(newx+","+newy)==false) q.add(new State(newx,newy));

            //state 5
            newx = jug1;
            newy = rem.y;
            if(visited.contains(newx+","+newy)==false) q.add(new State(newx,newy));

            //state 6
            newx = rem.x;
            newy = jug2;
            if(visited.contains(newx+","+newy)==false) q.add(new State(newx,newy));

        }
        return false;
    }
}
