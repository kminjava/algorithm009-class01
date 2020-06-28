package dynamic;

public class MaxProfitStop {
    public int maxProfit(int[] prices){
        int sell = 0,prev_sell = 0,buy = Integer.MIN_VALUE,pre_buy;
        for (int price : prices){
            pre_buy = buy;
            buy = Math.max(prev_sell-price,pre_buy);
            prev_sell = sell;
            sell = Math.max(pre_buy+price,prev_sell);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        MaxProfitStop maxProfitStop = new MaxProfitStop();
        int r = maxProfitStop.maxProfit(prices);
        System.out.println(r);
    }
}
