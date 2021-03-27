fun main() {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return nums[0].coerceAtLeast(nums[1])
        nums[1] = nums[0].coerceAtLeast(nums[1])
        for (i in 2 until nums.size) {
            nums[i] = nums[i - 1].coerceAtLeast(nums[i - 2] + nums[i])
        }
        return nums.last()
    }

    val input = intArrayOf(2, 7, 9, 3, 1)
    println(rob(input))

}