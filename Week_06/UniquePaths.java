package dynamic;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m,int n){
        /**
         * 令dp[i][j]是到达i,j最多路径
         * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
         * 对于第一行dp[0][j],或者第一列dp[i][0],由于都是在边界，所以只能为1
         * 因为我们每次只需要dp[i-1][j],dp[i][j-1]，所以每次只要记录这两个数;
         */
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j-1];
            }

        }
        return cur[n-1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        UniquePaths uniquePaths = new UniquePaths();
        int r = uniquePaths.uniquePaths(m,n);
        System.out.println(r);
    }
}
