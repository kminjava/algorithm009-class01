package str;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";
        String pre = strs[0];
       for (int i =1;i<strs.length;i++){
           while (strs[i].indexOf(pre) != 0)
               pre = pre.substring(0,pre.length()-1);
       }
       return pre;
    }

    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String r = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(r);
    }
}
