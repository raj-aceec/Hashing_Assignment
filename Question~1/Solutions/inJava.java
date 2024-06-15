import java.util.HashMap;

public class AnagramChecker {
    public static boolean areAnagrams(String str1, String str2) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char c : str1.toCharArray()) {
            if (c != ' ') {
                charCountMap.put(Character.toLowerCase(c), charCountMap.getOrDefault(Character.toLowerCase(c), 0) + 1);
            }
        }

        for (char c : str2.toCharArray()) {
            if (c != ' ') {
                charCountMap.put(Character.toLowerCase(c), charCountMap.getOrDefault(Character.toLowerCase(c), 0) - 1);
            }
        }

        for (int count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
