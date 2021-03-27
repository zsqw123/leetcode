fun main() {
    /**
     * 顺序遍历nums,若已有dp数组中所有数都小于num(通过二分查找),则num插入到dp的最后一项(即nums[len])
     *
     * @param nums IntArray 既储存了原始数组,也储存了dp数组, nums的[0,len]储存dp数组
     * @return Int
     */
    fun lengthOfLIS(nums: IntArray): Int {
        var len = 0 // len为最长严格递增子序列的长度
        for (num in nums) {
            var l = 0
            var h = len
            while (l < h) {
                val mid = ((h + l) shr 1)
                /**
                 * 在[l,h]之间查找,事实上nums在[l,h]范围内(事实上这个在dp数组范围内)是单调递增的,可以使用二分查找比num大的数里面最小的
                 * nums[mid] < num ----> l = mid + 1,并在[mid + 1,len]之间查找,找到比num大的数
                 * nums[mid] > num ----> h = mid,要找到"最小的"比num大的数,就需要在[l,mid]之间查找
                 */
                if (nums[mid] < num) l = mid + 1 else h = mid
            }
            nums[l] = num // dp全部都比num小,那么dp就在末尾添加一项num
            if (h == len) len++
        }
        return len
    }

    /**
     * 暴力算法,原理:
     * dp[i] = max(dp[j]+1，dp[k]+1，dp[p]+1，.....)
     *
     * @param nums IntArray
     * @return Int
     */
    fun lengthOfLIS1(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var result = 1
        val dpList = IntArray(nums.size) { 1 }
        for (i in nums.indices) {
            for (j in 0..i) {
                if (nums[j] < nums[i]) {
                    dpList[i] = (dpList[j] + 1).coerceAtLeast(dpList[i])
                }
            }
            result = result.coerceAtLeast(dpList[i])
        }
        return result
    }

    val input0 = intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6) //6
    val input1 = intArrayOf(0, 1, 0, 3, 2, 3) // 4
    val input2 = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18) // 4
    println(lengthOfLIS(input0))
    println(lengthOfLIS(input1))
    println(lengthOfLIS(input2))

}