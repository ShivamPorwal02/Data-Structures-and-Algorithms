package Revision;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
    public List<Integer> spiralOrder(int[][] arr) {
        int minr = 0;
        int minc = 0;
        int maxr = arr.length-1;
        int maxc = arr[0].length-1;
        List<Integer> lst = new ArrayList<>();
        int tc = arr.length*arr[0].length;
        int cnt = 0;
        while(cnt<tc){
            // top row

            for(int i=minr,j=minc;j<=maxc && cnt<tc;j++){
                lst.add(arr[i][j]);
                cnt++;
            }
            minr++;
            // right row
            for(int i=minr,j=maxc;i<=maxr && cnt<tc;i++){
                lst.add(arr[i][j]);
                cnt++;
            }
            maxc--;

            // bottom row
            for(int i=maxr,j=maxc;j>=minc && cnt<tc;j--){
                lst.add(arr[i][j]);
                cnt++;
            }
            maxr--;
            // left row
            for(int i=maxr,j=minc;i>=minr && cnt<tc;i--){
                lst.add(arr[i][j]);
                cnt++;
            }
            minc++;
        }
        return lst;
    }
}
