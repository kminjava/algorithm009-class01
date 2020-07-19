package str;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost){
    int len = cost.length;
    int f0 =0,f1 = 0;
    if (len == 0) return 0;
        for (int i = 0; i < len; i++) {
            int cur = cost[i] + Math.min(f0,f1);
            f0 = f1;
            f1 = cur;
        }
        return Math.min(f0,f1);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cost ={10,15,20};
        int r = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(r);
    }
}
