import java.io.*;
import java.util.*;

public class Solution {

    private final static int[] offset = {-1, 0, 1};

    private boolean hasNeighbours(int[][] matrix, int i, int j) {
        if((i >= 0) && (i  < matrix.length) && (j >= 0) && (j < matrix[0].length)) {
            if(matrix[i][j] == 1)
                return true;
        }
        return false;
    }

    private void goDownBitch(int[][] matrix, int i, int j, boolean[][] visited) {
        if(visited[i][j]) //if the node is already visited.
            return;

        visited[i][j] = true;
        int x, y;
        for(int l = 0; l < offset.length; l++) {
            x = offset[l];
            for(int m = 0; m < offset.length; m++) {
                y = offset[m];

                if(x == 0 && y == 0) //Don't consider the element itself.
                    continue;

                if(hasNeighbours(matrix, i + x, j + y)) {
                    goDownBitch(matrix, i + x, j + y, visited);
                }
            }
        }
    }

    public int countIslands(int[][] matrix) {
        int count = 0;
        if(matrix.length == 0)
            return 0;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    count += 1;
                    goDownBitch(matrix, i, j, visited);
               }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Solution x = new Solution();

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        System.out.println(x.countIslands(matrix));
    }
}
