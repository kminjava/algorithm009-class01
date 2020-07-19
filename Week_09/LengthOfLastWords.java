package str;

public class LengthOfLastWords {
    public int lengthOfLastWord(String s){
//        if (null == s || s.length() == 0) return 0;
//        String[] word = s.split(" ");
//        int w = word.length;
//        int len = 0;
//        if (w > 0) {
//            for (int i = word.length - 1; i > word.length - 2; i--) {
//                len = word[i].length();
//            }
//        }else {
//            return 0;
//        }
//        return len;

        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public static void main(String[] args) {
        String s = "this is a very good question you can say that again";
        LengthOfLastWords lengthOfLastWords = new LengthOfLastWords();
        int r = lengthOfLastWords.lengthOfLastWord(s);
        System.out.println(r);
    }
}
