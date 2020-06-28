package dynamic;

public class Change {
    public int change(int amount,int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins){
            for (int x = coin;x<amount+1;++x){
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        Change change = new Change();
        int r = change.change(amount,coins);
        System.out.println(r);
    }
}
