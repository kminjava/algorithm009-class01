package str;

import java.util.HashSet;
import java.util.Set;

public class NumJeweIsInStones {
    public int numJeweIsInStones(String J,String S){
//        Map<Character,Integer> map = new HashMap<>();
//        int r = 0;
//        for (int i = 0; i < J.length(); i++) {
//            char j = J.charAt(i);
//            map.put(j,i);
//        }
//        for (int i = 0; i < S.length(); i++) {
//            char s = S.charAt(i);
//            if (map.containsKey(s)) r++;
//        }
//        return r;
        int r = 0;
        Set set = new HashSet<>();
        for (char j : J.toCharArray()){
            set.add(j);
        }
        for (char s : S.toCharArray()){
            if (set.contains(s)) r++;
        }
        return r;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        NumJeweIsInStones numJeweIsInStones = new NumJeweIsInStones();
        int r = numJeweIsInStones.numJeweIsInStones(J,S);
        System.out.println(r);
    }
}
