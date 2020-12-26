fun main() {
    /**
     * 假定结果 dp[i] 以 nums[i] 作为结尾,于是有
     * dp[i]=max(dp[i-1]+nums[i],nums[i])
     * ...
     * dp[0]=nums[0]
     *
     * @param nums IntArray
     * @return Int
     */
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var dp = nums[0]
        var max = dp
        for (i in 1 until nums.size) {
            dp = (dp + nums[i]).coerceAtLeast(nums[i])
            max = max.coerceAtLeast(dp)
        }
        return max
    }

    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4, -1, 2, 1, -5, 2, 4, -1, 2, 1, -5)
    val nums1 = intArrayOf(1, -2, 0)
    println(maxSubArray(nums))
}