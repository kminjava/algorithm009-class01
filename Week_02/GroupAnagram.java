package map;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> r = groupAnagram(str);
        System.out.println(r.toString());
    }

    private static List<List<String>> groupAnagram(String[] str) {
        if (str.length == 0) return new ArrayList<>();
        Map<String, List<String>> mappings = new HashMap<>();
        int[] count = new int[26];
        for (String s : str) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!mappings.containsKey(key)) mappings.put(key,new ArrayList<>());
            mappings.get(key).add(s);
        }
        return new ArrayList<>(mappings.values());
    }

}
