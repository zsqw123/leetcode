fun main() {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var p1 = m - 1
        var p2 = n - 1
        var p = m + n - 1
        while (p1 >= 0 && p2 >= 0)
            nums1[p--] = if (nums1[p1] < nums2[p2]) nums2[p2--] else nums1[p1--]
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1) // 剩下的
    }

    fun merge0(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var a = m - 1
        var b = n - 1
        for (i in nums1.size - 1 downTo 0) {
            if (a >= 0) {
                nums1[i] = if (b >= 0) if (nums1[a] > nums2[b]) nums1[a--] else nums2[b--]
                else nums1[a--]
            } else if (b >= 0) {
                nums1[i] = if (a >= 0) if (nums1[a] > nums2[b]) nums1[a--] else nums2[b--]
                else nums2[b--]
            }
        }
    }
}