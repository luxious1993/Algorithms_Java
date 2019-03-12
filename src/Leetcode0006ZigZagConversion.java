import java.util.Arrays;

public class Leetcode0006ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }
        String[] resArray = new String[numRows];
        Arrays.fill(resArray, "");
        int row = 0;
        int delta = 1;
        for (int i = 0; i < s.length(); i++) {
            resArray[row] += s.charAt(i);
            row += delta;
            if (row >= numRows) {
                delta = -1;
                row = numRows - 2;
            }
            if (row < 0) {
                delta = 1;
                row = 1;
            }
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res += resArray[i];
        }
        return res;
    }
}
