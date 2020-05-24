package array;

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{1,2,3,4,5,6,7};
        k %= nums.length;
        rotate(nums,0,nums.length-1);
        rotate(nums,0,k-1);
        rotate(nums,k,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }

    private static void rotate(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
