public class Leetcode0014LongestCommonPrefix {
    //binary search
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        int left = 1;
        int right = minLen;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkPrefix(strs, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0, left - 1);
    }
    private boolean checkPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
