package bit;

import java.util.Arrays;
import java.util.TreeMap;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1,int[] arr2){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int n: arr1) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int i =0;
        for (int n : arr2){
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);
        }
        for (int n : map.keySet()){
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] r = relativeSortArray.relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(r));
    }
}
