package array;

import java.util.Arrays;
import java.util.List;

public class MoveZero {
    static int[] nums = new int[]{0,1,0,12,4,5,8};
    public static void main(String[] args) {
        moveZero(nums);
    }

    private static void moveZero(int[] nums) {
        System.out.println("输入的数组为："  +Arrays.toString(nums));
            int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
        System.out.println("输出的数组为：" +Arrays.toString(nums));
    }
}
