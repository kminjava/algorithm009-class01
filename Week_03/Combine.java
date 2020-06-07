package recur;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> r = combine(ans,new ArrayList<Integer>(),1,n,k);
        System.out.println(r.toString());
    }

    private static List<List<Integer>> combine(List<List<Integer>> ans, ArrayList<Integer> list, int start, int n, int k) {
        if (k == 0){
            ans.add(new ArrayList<Integer>(list));
            return ans;
        }
        for (int i = start;i<=n-k+1;i++){
            list.add(i);
            combine(ans,list,i+1,n,k-1);
            list.remove(list.size() - 1);
        }
        return ans;
    }


}
