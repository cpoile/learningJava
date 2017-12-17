package chris.ch1a;

import java.util.HashMap;
import java.util.Map;

public class HrAnagrams {
    static boolean isAnagram(String a, String b) {
        // construct a frequency map
        Map<Character, Integer> mapA = getFreqMap(a.toLowerCase());
        Map<Character, Integer> mapB = getFreqMap(b.toLowerCase());
        // compare the maps
        return mapA.equals(mapB);
    }

    static Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            res.put(s.charAt(i), res.getOrDefault(s.charAt(i), 0) + 1);
        }
        return res;
    }
}
