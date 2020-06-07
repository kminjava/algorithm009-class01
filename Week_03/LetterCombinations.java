package recur;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans.add("");
        while (ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for (char c : map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> r = letterCombinations.letterCombinations("23");
        System.out.println(r.toString());
    }
}
