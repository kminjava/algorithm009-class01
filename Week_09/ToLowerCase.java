package str;

public class ToLowerCase {
    public String toLowerCase(String str){
        if (str == null ) return null;
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<str.length();i++){
            char c = (char)(str.charAt(i) | (char)(32));
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "LOVELY";
        ToLowerCase toLowerCase = new ToLowerCase();
        String r = toLowerCase.toLowerCase(str);
        System.out.println(r);
    }
}
