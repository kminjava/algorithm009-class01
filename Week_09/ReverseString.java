package str;

import java.util.Arrays;

public class ReverseString {
    public void reverseString(char[] s){
        int left = 0,right = s.length - 1;
        while (left < right){
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
