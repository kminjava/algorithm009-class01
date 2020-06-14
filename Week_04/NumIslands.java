package serach;

public class NumIslands {
    private int n;
    private int m;
    public int numIslands(char[][] grid){
       int count = 0;
       n = grid.length;
       if (n == 0) return 0;
       m = grid[0].length;
       for (int i = 0;i<n;i++){
           for (int j = 0; j < m; j++) {
               if (grid[i][j] == '1'){
                   dfsMarking(grid,i,j);
                   ++count;
               }
           }
       }
       return count;
    }

    private void dfsMarking(char[][] grid, int i, int j) {
        if (i < 0 || j <0 || i>= n || j >=m || grid[i][j] != '1') return;
        grid[i][j] ='0';
        dfsMarking(grid,i+1,j);
        dfsMarking(grid,i-1,j);
        dfsMarking(grid,i,j+1);
        dfsMarking(grid,i,j-1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        NumIslands numIslands = new NumIslands();
        int r = numIslands.numIslands(grid);
        System.out.println(r);
    }
}
