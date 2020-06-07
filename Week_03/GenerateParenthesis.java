package recur;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generate(0,0,n,"");
        System.out.println(result.toString());

    }
    private static List<String> generate(int left, int right,int n, String s) {
        // terminator
        if(left == n && right == n){
            list.add(s);
            return list;
        }
        //drill down
        if(left < n){
            generate(left  + 1,right,n,s +"(");
        }
        if(left > right && right < n){
            generate(left,right+1,n,s +")");
        }
        return list;
    }
}
