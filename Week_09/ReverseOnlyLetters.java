package str;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            while (i < j && !Character.isLetter(sb.charAt(i))) ++i;
            while (i < j && !Character.isLetter(sb.charAt(j))) --j;
            sb.setCharAt(i, s.charAt(j));
            sb.setCharAt(j, s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverse = new ReverseOnlyLetters();
        String s = "ab-cd";
        String r = reverse.reverseOnlyLetters(s);
        System.out.println(r);
    }
}
