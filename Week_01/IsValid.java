package array;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        String s = "()[]}";
        boolean isValid = isValid(s);
        System.out.println("输出结果:"+isValid);

    }

    private static boolean isValid(String s) {
        HashMap<Character,Character> mappings = new HashMap<Character, Character>();
        mappings.put(')','(');
        mappings.put('}','{');
        mappings.put(']','[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(mappings.containsKey(c)){// value如果包含左括号({[
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
