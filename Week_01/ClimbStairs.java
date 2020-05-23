package array;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println("请输入楼梯的阶数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = climbStairs(n);
        System.out.println("输出的结果为:"+r);
    }

    private static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
