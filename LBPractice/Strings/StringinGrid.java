package LoveBabbar.Strings;

import java.util.ArrayList;

public class StringinGrid {
    static int R, C;

    // For searching in all 8 direction
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // This function searches in all
    // 8-direction from point
    // (row, col) in grid[][]
    static boolean search2D(char[][] grid, int row,
                            int col, String word)
    {
        // If first character of word
        // doesn't match with
        // given starting point in grid.
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        // Search word in all 8 directions
        // starting from (row, col)
        for (int dir = 0; dir < 8; dir++) {
            // Initialize starting point
            // for current direction
            int k, rd = row + x[dir], cd = col + y[dir];

            // First character is already checked,
            // match remaining characters
            for (k = 1; k < len; k++) {
                // If out of bound break
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;

                // If not matched, break
                if (grid[rd][cd] != word.charAt(k))
                    break;

                // Moving in particular direction
                rd += x[dir];
                cd += y[dir];
            }

            // If all character matched,
            // then value of must
            // be equal to length of word
            if (k == len)
                return true;
        }
        return false;
    }
    public int[][] searchWord(char[][] grid, String word)
    {
        ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
        R = grid.length;
        C = grid[0].length;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (search2D(grid, row, col, word)){
                    ArrayList<Integer> lst = new ArrayList<>();
                    lst.add(row);
                    lst.add(col);
                    list.add(lst);
                }
            }
        }
        int[][] arr = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<2;j++){
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }
}
