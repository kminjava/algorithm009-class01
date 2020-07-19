package str;

public class RaceCar {
    public int raceCar(int target){
        int[] dp = new int[target +1];
        for (int i = 1; i <= target ; i++) {
            dp[i] = Integer.MAX_VALUE;
            int m = 1,j = 1;
            for (;j < i ; j =(1<< ++m)-1) {
                for (int q = 0,p=0; p<j ;p=(1<<++q)-1) {
                    dp[i] = Math.min(dp[i],m+1+q+1+dp[i-(j-p)]);
                }
            }
            dp[i] = Math.min(dp[i],m+(i==j ? 0 : 1+dp[j-i]));
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int target = 6;
        RaceCar raceCar = new RaceCar();
        int r = raceCar.raceCar(3);
        System.out.println(r);
    }
}
