package dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CanAcross {
    public boolean canCross(int[] stones){
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i],new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])){
                for (int step = k-1;step<=k+1;step++){
                    if (step >0 && map.containsKey(stones[i] + step)){
                        map.get(stones[i] + step).add(step);
                    }
                }

            }
        }
        return map.get(stones[stones.length -1]).size() > 0;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        CanAcross canAcross = new CanAcross();
        boolean r = canAcross.canCross(stones);
        System.out.println(r);
    }
}
