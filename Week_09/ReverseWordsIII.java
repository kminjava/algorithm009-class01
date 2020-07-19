package str;

public class ReverseWordsIII {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = 0;
        while (j < c.length) {
            while (i < c.length && c[i] == ' ') ++i;
            while (j < c.length && c[j] != ' ') ++j;
            revrese(c, i, j - 1);
            i = j;
            ++j;
        }
        s = String.valueOf(c);
        return s;
    }

    private void revrese(char[] arr, int start, int end) {
        if (arr.length == 0) return;
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWordsIII reverseWordsIII = new ReverseWordsIII();
        String r = reverseWordsIII.reverseWords(s);
        System.out.println(r);
    }
}
