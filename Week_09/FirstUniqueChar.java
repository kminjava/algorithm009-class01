package str;


public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
            for (int j = 0; j <s.length() ; j++) {
                if (freq[s.charAt(j)-'a']==1){
                    return j;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        int r = firstUniqueChar.firstUniqChar(s);
        System.out.println(r);
    }
}
