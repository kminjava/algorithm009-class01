package map;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        int[] r = topKFrequent(nums,k);
        System.out.println(Arrays.toString(r));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()){
            if (pq.size() < k){
                pq.add(key);
            }else if (map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

}
