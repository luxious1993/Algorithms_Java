public class Leetcode0009PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int y = 0;
        while (num > 0) {
            y = y * 10 + num % 10;
            num /= 10;
        }
        return x == y;
    }
}
