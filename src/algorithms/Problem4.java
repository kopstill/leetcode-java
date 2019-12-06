package algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Median of Two Sorted Arrays
 * 寻找两个有序数组的中位数
 */
public class Problem4 {

    @Test
    public void testFindMedianSortedArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        Assert.assertEquals(2.5, findMedianSortedArrays(nums1, nums2), 0);
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Arrays cannot be null");
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int len0 = len1 + len2;

        int[] nums0 = new int[len0];
        System.arraycopy(nums1, 0, nums0, 0, len1);
        System.arraycopy(nums2, 0, nums0, len1, len2);

        Arrays.sort(nums0);

        if (len0 % 2 == 0) {
            return ((nums0[(len0 / 2) - 1] + nums0[len0 / 2]) / 2d);
        } else {
            return nums0[len0 / 2];
        }
    }

}
