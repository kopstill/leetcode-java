package algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * Longest Palindromic Substring
 * 最长回文子串
 */
public class Problem5 {

    @Test
    public void testLongestPalindrome() {
        String s = "babad";
        Assert.assertEquals("bab", longestPalindrome(s));
    }

    private String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.equals("")) return "";

        String result = "";
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > max) {
                    result = temp;
                    max = Math.max(max, result.length());
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

}
