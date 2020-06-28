package dynamic;

public class MaxProfit3 {
    public int maxProfit(int[] prices){
        int hold1 = Integer.MIN_VALUE,hold2 = Integer.MIN_VALUE;
        int release1 = 0,release2 = 0;
        for (int i : prices) {
            release2 = Math.max(release2,hold2+i);
            hold2 = Math.max(hold2,release1-i);
            release1 = Math.max(release1,hold1+i);
            hold1 = Math.max(hold1,-i);
        }
        return release2;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,5,0,0,3,1,4};
        MaxProfit3 maxProfit3 = new MaxProfit3();
        int r = maxProfit3.maxProfit(nums);
        System.out.println(r);
    }
}
