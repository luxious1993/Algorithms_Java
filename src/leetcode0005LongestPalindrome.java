public class leetcode0005LongestPalindrome {
    //special DP
    private int start = 0;
    private int max = 1;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(start, start + max);
    }
    private void helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > max) {
            start = i + 1;
            max = j - i - 1;
        }
    }
}
