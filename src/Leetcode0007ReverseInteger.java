public class Leetcode0007ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean isNegative = x < 0? true : false;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int num = isNegative? -x : x;
        int res = 0;
        while (num > 0) {
            int digit = num % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            res = 10 * res + digit;
            num /= 10;
        }
        return isNegative? -res : res;
    }
    /*
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean isNegative = x < 0? true : false;
        long num = (long)Math.abs(x);
        long res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        res = isNegative? -res : res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
     */
}
