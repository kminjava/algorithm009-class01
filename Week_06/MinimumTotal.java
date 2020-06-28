package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangel){
        if (triangel == null || triangel.size() == 0){
            return 0;
        }
        int rowNum = triangel.size();
        int[] dp = new int[rowNum];
        for (int i = 0; i < triangel.get(rowNum - 1).size(); i++) {
            dp[i] = triangel.get(rowNum - 1).get(i);
        }
        for (int row = rowNum -2;row >=0;row--){
            for (int col = 0;col <= row;col++){
                dp[col] = Math.min(dp[col],dp[col+1]) + triangel.get(row).get(col);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> triangels = new ArrayList<>();
        triangels.add(list1);
        triangels.add(list2);
        triangels.add(list3);
        triangels.add(list4);
        MinimumTotal minimumTotal = new MinimumTotal();
        int r = minimumTotal.minimumTotal(triangels);
        System.out.println(r);
    }
}
