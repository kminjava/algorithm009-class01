package recur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<Integer>(),nums,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        SubSets subSets = new SubSets();
        int[] nums = {1,2,3};
        List<List<Integer>> r = subSets.subsets(nums);
        System.out.println(r.toString());
    }

}
