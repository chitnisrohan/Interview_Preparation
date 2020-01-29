package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {



    /*

                    NOT MY SOLUTION

     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<Integer>();
        if(matrix.length==0){
            return spiralList;
        }
        int n = matrix[0].length;
        int m = matrix.length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0; int c = 0; int di=0;

        for(int i=0; i<m*n; i++){
            spiralList.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r+dr[di];
            int cc = c+dc[di];

            if(cr>=0 && cr<m && cc>=0 && cc<n && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else{
                di = (di+1) % 4;
                // here we are modifying r and c instead of cr and cc.
                // the reason is that cr and cc are now either seen or out of matrix.
                // so we need to go 1 step back and update r and c
                r = r+dr[di];
                c = c+dc[di];
            }
        }
        return spiralList;
    }
}
