package array;

import java.util.Arrays;

public class MaxArea {
    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int r = maxArea(nums);
        System.out.println("最大面积为:"+r);
    }

    private static int maxArea(int[] nums) {
        System.out.println("输入的数组为:"+ Arrays.toString(nums));
        int l = 0,r=nums.length-1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int area = Math.min(nums[l],nums[r])*(r-l);
            ans = Math.max(ans,area);
            if(nums[l] <= nums[r]){
                ++l;
            }
            --r;
        }
        return ans;
    }
}
