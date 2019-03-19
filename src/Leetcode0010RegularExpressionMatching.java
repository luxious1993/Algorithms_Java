public class Leetcode0010RegularExpressionMatching {
    //dp
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //from [0, i) in s match to [0,j) in p
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (j > 1 && p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                        //dp[i][j - 2] is delete p.charAt(j - 1)
                        //dp[i][j - 1] is one time p.charAt(j - 1)
                        //dp[i - 1][j] is repeat p.charAt(j - 1), because p.charAt(j - 1) can match s.charAt(i - 1)
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
