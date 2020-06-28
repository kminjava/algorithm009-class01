package dynamic;

public class MaxSubArray {
    public int maxSubArray(int[] A){
        /**
         * 动态规划
         * 首先对数组进行遍历，当前最大连续子序列和为
         */
        int n = A.length;
        int[] dp = new int[n];//dp[i]means the maxium subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (dp[i-1] > 0 ? dp[i-1] :0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A ={1,-2,3,4,5,6};
        MaxSubArray maxSubArray = new MaxSubArray();
        int r = maxSubArray.maxSubArray(A);
        System.out.println(r);
    }
}
