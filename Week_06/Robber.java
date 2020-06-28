package dynamic;

public class Robber {
    public int rob(int[] nums){
        /**
         * 动态规划
         * 动态规划方程：dp[n] = MAX(dp[n-1],dp[n-2]+num);
         * 由于不可以在相邻的房屋闯入，所以在当前的位置n房屋可盗窃的最大值，要么就是n-1房屋，要么就是
         * n-2房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
         * 时间复杂度O(n)，n为数组长度
         */
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Robber robber = new Robber();
        int r = robber.rob(nums);
        System.out.println(r);
    }
}
