package com.leecode;


/**
 * task:
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
        Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
        1 <= m + n <= 200
        -109 <= nums1[i], nums2[j] <= 109
*/

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of both arrays
        int p1 = m - 1; // Pointer for nums1
        int p2 = n - 1; // Pointer for nums2
        int p = m + n - 1; // Pointer for the merged array (which is nums1)

        // While there are elements in both arrays
        while (p1 >= 0 && p2 >= 0) {
            // Compare elements from the end of both arrays
            // Place the larger element at the end of nums1
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        // (If there are remaining elements in nums1, they are already in the right place)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        // Example 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println("Example 1 Output: " + java.util.Arrays.toString(nums1));

        // Example 2
        int[] nums3 = {1};
        int[] nums4 = {};
        solution.merge(nums3, 1, nums4, 0);
        System.out.println("Example 2 Output: " + java.util.Arrays.toString(nums3));

        // Example 3
        int[] nums5 = {0};
        int[] nums6 = {1};
        solution.merge(nums5, 0, nums6, 1);
        System.out.println("Example 3 Output: " + java.util.Arrays.toString(nums5));
    }
}
