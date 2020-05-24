package array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] nums = new int[]{1,9,9};
        int[] r = plusOne(nums);
        System.out.println(Arrays.toString(r));
    }

    private static int[] plusOne(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >=0; i--) {
            nums[i] ++;
            nums[i] %= 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        nums = new int[len + 1];
        nums[0] = 1;
        return nums;
    }
}
