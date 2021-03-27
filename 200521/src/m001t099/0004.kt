package m001t099

fun main() {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val shortLen = nums1.size
        val longLen = nums2.size
        if (shortLen > longLen) return findMedianSortedArrays(nums2, nums1)
        val leftTotal = (shortLen + longLen + 1) / 2
        var left = 0
        var right = shortLen
        // nums1[i - 1] <= nums2[j]
        // nums2[j - 1] <= nums1[i]
        while (left < right) {
            val i = left + (right - left + 1) / 2
            val j = leftTotal - i
            if (nums1[i - 1] > nums2[j]) right = i - 1
            else left = i
        }
        val i = left
        val j = leftTotal - i
        val nums1L = if (i == 0) Int.MIN_VALUE else nums1[i - 1]
        val nums1R = if (i == shortLen) Int.MAX_VALUE else nums1[i]
        val nums2L = if (j == 0) Int.MIN_VALUE else nums2[j - 1]
        val nums2R = if (j == longLen) Int.MAX_VALUE else nums2[j]
        return if ((shortLen + longLen) % 2 == 0) (maxOf(nums1L, nums2L) + minOf(nums1R, nums2R)) / 2.0
        else maxOf(nums1L, nums2L).toDouble()
    }
}