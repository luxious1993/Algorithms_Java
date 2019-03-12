public class Leetcode0008StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        boolean isNegative = false;
        int start = 0;
        if (str.length() == 0 || str.charAt(start) != '-' && str.charAt(start) != '+' && !isNumber(str.charAt(start))) {
            return 0;
        }
        if (str.charAt(start) == '-') {
            isNegative = true;
        }
        if (!isNumber(str.charAt(0))) {
            start++;
        }
        if (start >= str.length() || !isNumber(str.charAt(start))) {
            return 0;
        }
        long num = 0;
        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isNumber(ch)) {
                break;
            }
            int digit = ch - '0';
            num = num * 10 + digit;
            if (isNegative && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!isNegative && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        num = isNegative? -num : num;
        return (int)num;
    }
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
    /*
    public int myAtoi(String str) {
        str = str.trim();
        boolean isNegative = false;
        int start = 0;
        if (str.length() == 0 || str.charAt(start) != '-' && str.charAt(start) != '+' && !isNumber(str.charAt(start))) {
            return 0;
        }
        if (str.charAt(start) == '-') {
            isNegative = true;
        }
        if (!isNumber(str.charAt(0))) {
            start++;
        }
        if (start >= str.length() || !isNumber(str.charAt(start))) {
            return 0;
        }
        int num = 0;
        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isNumber(ch)) {
                break;
            }
            int digit = ch - '0';
            if (num > Integer.MAX_VALUE / 10) {
                return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (!isNegative && num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (isNegative && num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10 + 1) {
                return Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
        }
        return isNegative? -num : num;
    }
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
     */
}
