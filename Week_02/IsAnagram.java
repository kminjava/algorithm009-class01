package map;

public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "granaam";
        boolean r = isAnagram(s,t);
        System.out.println(r);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
