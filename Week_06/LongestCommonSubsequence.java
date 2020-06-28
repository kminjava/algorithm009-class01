package dynamic;

public class LongestCommonSubsequence {
    public int longestCommonSubsequenc(String text1,String text2){
        if (text1 == null || text2 == null || text1.length() == 0
                || text2.length() == 0) return 0;
        int m = text1.length(),n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcdef";
        String text2 = "acef";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int r = longestCommonSubsequence.longestCommonSubsequenc(text1,text2);
        System.out.println(r);
    }
}
