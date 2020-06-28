package dynamic;

public class SplitArray {
    public int spiltArray(int[] nums,int m){
        if (nums == null) return -1;
        int[][] dp = new int[m][nums.length];
        dp[0][0] = nums[0];
        for (int i=1;i<nums.length;i++){
            dp[0][i] = nums[i]+dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j =i;j<nums.length;j++){
                int min = Integer.MAX_VALUE;
                for (int k =0;k<j;k++){
                    min = Math.min(min,Math.max(dp[i-1][k],dp[0][j]-dp[0][k]));
                }
                dp[i][j] = min;
            }
        }
        return dp[m-1][nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        SplitArray splitArray = new SplitArray();
        int r = splitArray.spiltArray(nums,m);
        System.out.println(r);
    }
}
