package dynamic;

public class MaxProfitWithFee {
    public int maxProfit(int[] prices,int fee){
        int n = prices.length;
        int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,tmp - prices[i] - fee);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        MaxProfitWithFee maxProfitWithFee = new MaxProfitWithFee();
        int r = maxProfitWithFee.maxProfit(prices,fee);
        System.out.println(r);
    }
}
