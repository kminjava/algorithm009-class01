package str;

public class NumDistinct {
    public int numDistinct(String s,String t){
        int[][] meme = new int[t.length()+1][s.length()+1];
        for (int j = 0; j <= s.length() ; j++) {
            meme[0][j] = 1;
        }
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)){
                    meme[i+1][j+1] = meme[i][j] + meme[i+1][j];
                }else {
                    meme[i+1][j+1] = meme[i+1][j];
                }
            }
        }
        return meme[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        NumDistinct numDistinct = new NumDistinct();
        int r = numDistinct.numDistinct(s,t);
        System.out.println(r);
    }
}
