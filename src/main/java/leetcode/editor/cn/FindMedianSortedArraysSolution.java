package leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5081 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
public class FindMedianSortedArraysSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int maxLength = nums1.length + nums2.length;
        int mid = maxLength / 2 + 1;
        int[] nums = new int[mid];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index1 >= nums1.length) {
                nums[i] = nums2[index2];
                index2++;
                continue;
            }
            if (index2 >= nums2.length) {
                nums[i] = nums1[index1];
                index1++;
                continue;
            }
            int temp = nums1[index1] - nums2[index2];
            if (temp < 0) {
                nums[i] = nums1[index1];
                index1++;
            } else {
                nums[i] = nums2[index2];
                index2++;
            }
        }
        if (maxLength % 2 == 1) {
            return nums[mid - 1];
        } else {
            return ((double) nums[mid - 1] + (double) nums[mid - 2]) / 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
