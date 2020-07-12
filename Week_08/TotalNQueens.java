package bit;

public class TotalNQueens {
    public int totalNQueens(int n){
        return backtrack(0,0,0,0,0,n);
    }
    public int backtrack(int row,int hills,int next_row,int dales,int count,int n){
        /**
         * row 当前位置皇后的行号
         * hills 主对角线占据情况【1=被占据，0=未被占据】
         * next_row 下一行被占据的情况
         * dales 次对角线占据情况
         * count 所有可行解的个数
         */
        // 棋盘所有的列都可放置，
        // 即，按位表示为 n 个 '1'
        // bin(cols) = 0b1111 (n = 4), bin(cols) = 0b111 (n = 3)
        // [1 = 可放置]

        int colums = (1<<n) -1;
        if (row == n) count++; //如果已经放置了n个皇后，累加可行解
        else {
            //当前行可用的列
            //！表示0和1的含义对于变量hills，next_row,dales的含义是相反的
            //1=未被占据
            int free_colums = colums & ~(hills | next_row | dales);
            //可以找到放置下一个皇后的列
            while (free_colums != 0){
                //free_columns 的第一个为‘1’的位，在该列我们放置当前皇后
                int curr_columns = - free_colums & free_colums;
                //放置皇后，并且排除对应的列
                free_colums ^= curr_columns;

                count = backtrack(row+1,(hills | curr_columns) << 1,
                        next_row | curr_columns,
                        (dales | curr_columns) >> 1,
                        count,n);

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        TotalNQueens totalNQueens = new TotalNQueens();
        int r = totalNQueens.totalNQueens(n);
        System.out.println(r);
    }
}
