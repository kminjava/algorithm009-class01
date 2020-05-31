package map;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] r = getLeastNumbers(arr,k);
        System.out.println(Arrays.toString(r));
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0){
            return new int[0];
        }
        Queue<Integer> pq = new PriorityQueue<>((v1,v2) -> (v2-v1));
        for (int num : arr){
            if(pq.size() < k){
                pq.offer(num);
            }else if (num < pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        int[] rex = new int[pq.size()];
        int idx = 0;
        for (int a : pq){
            rex[idx++] = a;
        }
        return rex;
    }
}
