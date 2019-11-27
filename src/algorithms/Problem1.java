package algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * Two sum
 * 两数之和
 */
public class Problem1 {

    @Test
    public void testTwoSum() {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        Assert.assertArrayEquals(twoSum(nums, target), new int[]{1, 2});
    }

    private static int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("Illegal two sum arguments");
    }

}
