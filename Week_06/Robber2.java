package dynamic;

import java.util.Arrays;

public class Robber2 {
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),
                myRob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0,cur = 0,tmp;
        for (int num : nums){
            tmp = cur;
            cur = Math.max(pre+num,cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Robber2 robber2 = new Robber2();
        int r = robber2.rob(nums);
        System.out.println(r);
    }
}
