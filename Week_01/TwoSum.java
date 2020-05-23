package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,8,9,13};
        int target = 12;
        int[] r = twoSum(nums,target);
        System.out.print("输出的结果为："+ Arrays.toString(r));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if(map.containsKey(c)){
                return new int[] {map.get(c),i};
            }
            map.put(nums[i],i);
        }
        throw  new IllegalArgumentException("no such solutions!");
    }


}
