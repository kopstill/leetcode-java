package algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Substring Without Repeating Characters
 * 无重复字符的最长子串
 */
public class Problem3 {

    @Test
    public void testLengthOfLongestSubstring() {
        String str = "helloworld";
        Assert.assertEquals(lengthOfLongestSubstring(str), 5);
    }

    private int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int len = str.length();
        int max = 1;
        List<Character> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(str.charAt(i));
            for (int j = i + 1; j < len; j++) {
                char c = str.charAt(j);
                if (list.contains(c)) {
                    list.clear();
                    break;
                } else {
                    list.add(c);
                }

                max = Math.max(max, list.size());
            }
        }

        return max;
    }

}
