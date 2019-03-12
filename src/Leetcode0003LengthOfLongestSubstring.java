import java.util.HashSet;
import java.util.Set;

public class Leetcode0003LengthOfLongestSubstring {
    //two pointer
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        int start = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                while (s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(ch);
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }
}
