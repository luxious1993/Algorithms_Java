public class Leetcode0004MedianOfTwoSortedArray {
    //recursive
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 + len2) % 2 == 0) {
            int res1 = findK(nums1, nums2, 0, 0, (len1 + len2) / 2 + 1);
            int res2 = findK(nums1, nums2, 0, 0, (len1 + len2) / 2);
            return (res1 + res2) / 2.0;
        }
        return (double) findK(nums1, nums2, 0, 0, (len1 + len2) / 2 + 1);
    }
    private int findK(int[] nums1, int[] nums2, int left1, int left2, int k) {
        if (left1 >= nums1.length) {
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        int num1 = left1 + k / 2 - 1 >= nums1.length? Integer.MAX_VALUE : nums1[left1 + k / 2 - 1];
        int num2 = left2 + k / 2 - 1 >= nums2.length? Integer.MAX_VALUE : nums2[left2 + k / 2 - 1];
        if (num1 < num2) {
            return findK(nums1, nums2, left1 + k / 2, left2, k - k / 2);
        } else {
            return findK(nums1, nums2, left1, left2 + k / 2, k - k / 2);
        }
    }
}
